SUMMARY = "Astoria config files"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=691d84ab639c4b8173db302930bf71f4"

inherit systemd
inherit useradd

USERADD_PACKAGES = "astoria-config"

RDEPENDS_${PN} = "python3-astoria python3-udiskie"

SRC_URI = " \
    file://LICENSE \
    file://astdiskd.service \
    file://astmetad.service \
    file://astprocd.service \
    "

S = "${WORKDIR}"

USERADD_PARAM:${PN} = "-r -G video astoria"

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "astdiskd.service astmetad.service astprocd.service"

DIRFILES = "1"

do_install () {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/astdiskd.service ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/astmetad.service ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/astprocd.service ${D}${systemd_system_unitdir}
}
