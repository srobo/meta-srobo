SUMMARY = "A fiducial marker system powered by OpenCV - Supports ArUco and April"
DESCRIPTION = "A fiducial marker system powered by OpenCV - Supports ArUco and April"
HOMEPAGE = "https://github.com/RealOrangeOne/zoloto"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=bfd7580e6f0deacd183d33dd0ee386d8"

SRC_URI[sha256sum] = "72153c55c316d04494ca8ab43f9cbc1fa4b0eebb972eeb9426ccb16f35610526"

PYPI_PACKAGE = "zoloto"
inherit pypi setuptools3

RDEPENDS:${PN} = "opencv python3-pyquaternion python3-numpy python3-cached-property"

BBCLASSEXTEND = "native nativesdk"
