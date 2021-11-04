SUMMARY = "Student Robotics API"
DESCRIPTION = "Student Robotics API"
HOMEPAGE = "http://github.com/srobo/sr-robot3"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1892732acd90517c8febc2b852fcbec3"

SRC_URI[sha256sum] = "ab9fc3a250ab9fcd2804690edc2ded318efcd23ae935f566036a66bdd793fe97"

PYPI_PACKAGE = "sr.robot3"
inherit pypi setuptools3

RDEPENDS:${PN} = "${PYTHON_PN}-pyserial python3-j5 python3-j5-zoloto python3-astoria"

BBCLASSEXTEND = "native nativesdk"
