SUMMARY = "Student Robotics API"
DESCRIPTION = "Student Robotics API"
HOMEPAGE = "http://github.com/srobo/sr-robot3"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1892732acd90517c8febc2b852fcbec3"

SRC_URI[sha256sum] = "4882f30841df2e7d2d3ea9a68d1f65e10a8bffd71de27a171b2483e535a99914"

PYPI_PACKAGE = "sr.robot3"
inherit pypi setuptools3

RDEPENDS:${PN} = "${PYTHON_PN}-pyserial ${PYTHON_PN}-j5 ${PYTHON_PN}-j5-zoloto ${PYTHON_PN}-astoria"

BBCLASSEXTEND = "native nativesdk"
