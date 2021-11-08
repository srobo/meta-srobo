SUMMARY = "Package set to define a SR Kit"


LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=691d84ab639c4b8173db302930bf71f4"

SRC_URI = " \
    file://LICENSE \
    file://10-srobo.rules \
    file://astoria.toml \
    "

DEPENDS =  "astoria-config"

S = "${WORKDIR}"

do_install () {
    install -d ${D}/usr/lib/udev/rules.d/
    install -d ${D}/etc/
    install -d ${D}/var/srobo/cache/
    chown -R astoria:astoria ${D}/var/srobo/cache/
    install -m 0644 ${WORKDIR}/10-srobo.rules ${D}/usr/lib/udev/rules.d/
    install -m 0644 ${WORKDIR}/astoria.toml ${D}/etc/
}