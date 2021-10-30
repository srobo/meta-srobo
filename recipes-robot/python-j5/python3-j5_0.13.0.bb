SUMMARY = "j5 Robotics Framework"
DESCRIPTION = "j5 Robotics Framework"
HOMEPAGE = "http://github.com/j5api/j5"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=44a99382609e909183f51320bcee1127"

SRC_URI[sha256sum] = "069a98ad6f0dbf9f38bd3af7d0a114c9dca1427820c8978fe95012f97ea21a32"

PYPI_PACKAGE = "j5"
inherit pypi setuptools3

RDEPENDS:${PN} = "${PYTHON_PN}-pyserial ${PYTHON_PN}-pyusb python3-cached-property ${PYTHON_PN}-typing-extensions ${PYTHON_PN}-pyquaternion"

BBCLASSEXTEND = "native nativesdk"
