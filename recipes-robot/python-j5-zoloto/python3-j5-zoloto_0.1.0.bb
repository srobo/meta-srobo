SUMMARY = "j5 integration for Zoloto computer vision"
DESCRIPTION = "j5 integration for Zoloto computer vision"
HOMEPAGE = "https://github.com/j5api/j5-zoloto"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=44a99382609e909183f51320bcee1127"

SRC_URI[sha256sum] = "5e1aa426f35fd5746655150e6f0f73c03edcbc27d4f7d872398d268d6f251b38"

PYPI_PACKAGE = "j5_zoloto"
inherit pypi setuptools3

RDEPENDS:${PN} = "${PYTHON_PN}-zoloto"

BBCLASSEXTEND = "native nativesdk"
