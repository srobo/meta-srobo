DESCRIPTION = "Student Robotics kit software image"
LICENSE = "MIT"

inherit core-image

IMAGE_FEATURES += " \
    debug-tweaks \
    ssh-server-dropbear \
    package-management \
    "

CORE_IMAGE_EXTRA_INSTALL += " \
    packagegroup-core-full-cmdline \
    python3 \
    systemd-analyze \
    python3-udiskie \
    python3-astoria \
    python3-sr-robot3 \
    srobo-kit \
    astoria-udiskie \
    astoria-config \
    mosquitto \
    servohack \
    python3-matplotlib \
    python3-pandas \
    python3-pyudev \
    "

