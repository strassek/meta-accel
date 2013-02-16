SUMMARY = "Linux kernel industrial I/O utilities"
SECTION = "base"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/project/iioutils/iioutils/iioutils-${PV}.tar.gz"
S = "${WORKDIR}/iioutils"

SRC_URI[md5sum] = "8a88b711d3d6a7fedd75af833c5470cb"
SRC_URI[sha256sum] = "a5009b02d80b7bb2dc073e339fd9bda961d1131f6b20127d8860c86d2578e09c"

inherit autotools
