SUMMARY = "Servo Hack"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2e7439106ad0c88223e853736a7b7aec"

inherit systemd

RDEPENDS:${PN} = "python3-astoria"

SRC_URI = " \
    file://LICENSE \
    file://servohack.service \
    file://astplodd.py \
    "

S = "${WORKDIR}"

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "servohack.service"

DIRFILES = "1"

do_install () {
    install -d ${D}${systemd_system_unitdir}
    install -d ${D}/usr/bin/
    install -m 0644 ${WORKDIR}/servohack.service ${D}${systemd_system_unitdir}
    install -m 0755 ${WORKDIR}/astplodd.py ${D}/usr/bin/
}
