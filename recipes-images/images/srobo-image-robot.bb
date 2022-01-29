DESCRIPTION = "Student Robotics kit software image"
LICENSE = "MIT"

inherit core-image

IMAGE_FEATURES += " \
    debug-tweaks \
    ssh-server-dropbear \
    package-management \
    "

CORE_IMAGE_EXTRA_INSTALL += " \
    packagegroup-core-full-cmdline \
    srobo-kit \
    systemd-analyze \
    python3-matplotlib \
    python3-pandas \
    python3-pillow \
    python3-pyudev \
    "
