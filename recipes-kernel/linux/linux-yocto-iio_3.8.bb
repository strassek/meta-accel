require recipes-kernel/linux/linux-yocto.inc
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

# Override SRC_URI in a bbappend file to point at a different source
# tree if you do not want to build from Linus' tree.


# Override SRCREV to point to a different commit in a bbappend file to
# build a different release of the Linux kernel.
# tag: v3.4 76e10d158efb6d4516018846f60c2ab5501900bc

SRC_URI = "git:///home/strassek/repos/linux.git;protocol=file;nocheckout=1;branch=master"

EXTRA_SRC_URI = "\
    file://gpiolib.cfg \
    file://st_accel.cfg \
    file://i2c_hacking.cfg \
    file://fri2_platform.cfg \
    file://kempld.cfg \
    file://pca953x.cfg"

FS_SRC_URI = "\
    file://devtmpfs.cfg \
    file://debugfs.cfg \
    file://btrfs.cfg \
    file://ext2.cfg \
    file://ext3.cfg \
    file://ext4.cfg"

NET_SRC_URI = "\
    file://ipsec.cfg \
    file://ipv6.cfg \
    file://ipsec6.cfg \
    file://ip_nf.cfg \
    file://ip6_nf.cfg \
    file://bridge.cfg"
 
STD_SRC_URI = "\
    file://base.cfg \
    file://standard.cfg \
    ${FS_SRC_URI} \
    ${NET_SRC_URI}"

FRI2_STD_SRC_URI = "\
    ${STD_SRC_URI} \
    file://fri2.cfg \
    file://efi.cfg \
    file://smp.cfg \
    file://hpet.cfg \
    file://no_hz.cfg \
    file://hz_1000.cfg \
    file://x86.cfg \
    file://eg20t.cfg \
    file://dmaengine.cfg \
    file://f5521gw.cfg \
    file://usb-net.cfg \
    file://intel.cfg \
    file://usb-base.cfg \
    file://ehci-hcd.cfg \
    file://ohci-hcd.cfg \
    file://iwlwifi.cfg \
    file://mac80211.cfg \
    file://efi-ext.cfg \
    file://scsi.cfg \
    file://disk.cfg \
    file://usb-mass-storage.cfg \
    file://boot-live.cfg \
    file://latencytop.cfg \
    file://profiling.cfg"

SRC_URI += "\
    ${FRI2_STD_SRC_URI} \
    ${EXTRA_SRC_URI}"

SRCREV ?= "${AUTOREV}"
LINUX_VERSION ?= "3.8"
LINUX_VERSION_EXTENSION ?= "-rc5"

PR = "${INC_PR}.0"
PV = "${LINUX_VERSION}+git${SRCPV}"

# Override COMPATIBLE_MACHINE to include your machine in a bbappend
# file. Leaving it empty here ensures an early explicit build failure.
COMPATIBLE_MACHINE_fri2-noemgd-accel = "fri2-noemgd-accel"

# Functionality flags
#KERNEL_REVISION_CHECKING=""
#KERNEL_FEATURES_append = " features/netfilter"
#KERNEL_FEATURES_append = " ${@bb.utils.contains("TUNE_FEATURES", "mx32", " cfg/x32", "" ,d)}"

module_autoload_iwlwifi = "iwlwifi"
