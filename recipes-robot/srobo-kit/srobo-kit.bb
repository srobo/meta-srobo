SUMMARY = "Package set to define a SR Kit"


LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=691d84ab639c4b8173db302930bf71f4"

SRC_URI = " \
    file://LICENSE \
    file://10-srobo.rules \
    file://astoria.toml \
    file://exynos-blacklist.conf \
    file://dnsmasq.conf \
    file://nftables.conf \
    file://br0.netdev \
    file://br0.network \
    file://eth0.network \
    "

DEPENDS = "astoria-config"

RDEPENDS:${PN} = "astoria-udiskie python3-sr-robot3 servohack dnsmasq nftables"

S = "${WORKDIR}"

do_install () {
    install -d ${D}/usr/lib/udev/rules.d/
    install -d ${D}/etc/
    install -d ${D}/var/srobo/cache/
    chown -R astoria:astoria ${D}/var/srobo/cache/
    install -m 0644 ${WORKDIR}/10-srobo.rules ${D}/usr/lib/udev/rules.d/
    install -m 0644 ${WORKDIR}/astoria.toml ${D}/etc/
    install -d ${D}/etc/modprobe.d/
    install -m 0644 ${WORKDIR}/exynos-blacklist.conf ${D}/etc/modprobe.d/
    install -m 0644 ${WORKDIR}/dnsmasq.conf ${D}/etc/dnsmasq.d/srobo.conf
    install -m 0644 ${WORKDIR}/nftables.conf ${D}/etc/nftables.conf
    install -d ${D}/etc/systemd/network
    install -m 0644 ${WORKDIR}/br0.netdev ${D}/etc/systemd/network/br0.netdev
    install -m 0644 ${WORKDIR}/br0.network ${D}/etc/systemd/network/br0.network
    install -m 0644 ${WORKDIR}/eth0.network ${D}/etc/systemd/network/eth0.network
    install -d ${D}/etc/sysctl.d
    echo "net.ipv4.ip_forward=1" > ${D}/etc/sysctl.d/ip_forward.conf
}
