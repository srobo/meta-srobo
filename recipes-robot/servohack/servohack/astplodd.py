#!/usr/bin/env python3
import asyncio
import logging
from json import JSONDecodeError, loads
from pathlib import Path
from typing import Match, NamedTuple, Optional

from astoria.common.consumer import StateConsumer
from astoria.common.messages.astprocd import CodeStatus, ProcessManagerMessage

LOGGER = logging.getLogger(__name__)

logging.basicConfig(
    level=logging.INFO,
    format=f"%(asctime)s astplodd %(name)s %(levelname)s %(message)s",
    datefmt="%Y-%m-%d %H:%M:%S",
)

loop = asyncio.get_event_loop()

class ServoHackConsumer(StateConsumer):
    """Astoria consumer to fetch metadata."""

    name = "astplodd"

    def _setup_logging(self, verbose: bool, *, welcome_message: bool = True) -> None:
        # Suppress INFO messages from gmqtt
        logging.getLogger("gmqtt").setLevel(logging.WARNING)

    def _init(self) -> None:
        """Initialise consumer."""
        self._mqtt.subscribe("astprocd", self._handle_astprocd_message)
        self._code_started = False

    async def _handle_astprocd_message(
        self,
        match: Match[str],
        payload: str,
    ) -> None:
        """Handle astprocd status messages."""
        try:
            message = ProcessManagerMessage(**loads(payload))
            if message.status == ProcessManagerMessage.Status.RUNNING:
                LOGGER.debug(f"Received process info: {message}")
                if message.code_status is CodeStatus.RUNNING:
                    self._code_started = True
                    LOGGER.info("Code has been started")
                elif message.code_status is None and self._code_started:
                    LOGGER.info("USB removed, rebooting")
                    await asyncio.create_subprocess_exec("/bin/systemctl", "reboot")
            else:
                LOGGER.warn("Cannot get process info, astprocd is not running")
        except JSONDecodeError:
            LOGGER.error("Could not decode JSON metadata.")

    async def main(self) -> None:
        """Main method of the command."""
        await self.wait_loop()

if __name__ == "__main__":
    consumer = ServoHackConsumer(True, None)
    loop.run_until_complete(consumer.run())

