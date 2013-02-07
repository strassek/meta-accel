DESCRIPTION = "Kontron KEMPLD Linux Kernel Driver Package"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

inherit module

PR = "r0"

SRC_URI = "git://github.com/strassek/kempld.git;branch=master;protocol=git"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

