SUMMARY = "Robot Management System for Student Robotics Kit"
DESCRIPTION = "Robot Management System for Student Robotics Kit"
HOMEPAGE = "https://github.com/srobo/astoria"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=afb9f374f84b496f0a6f7b4d8d76d533"

SRC_URI[sha256sum] = "d7ac8649212575598127b7c77eeb0377f8ef89c6f8a71b95f64662032ff2db7f"

PYPI_PACKAGE = "astoria"
inherit pypi setuptools3

RDEPENDS:${PN} = "hostapd ${PYTHON_PN}-pydantic ${PYTHON_PN}-click ${PYTHON_PN}-dbus-next ${PYTHON_PN}-gmqtt ${PYTHON_PN}-toml udisks2"

BBCLASSEXTEND = "native nativesdk"
