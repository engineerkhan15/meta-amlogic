SUMMARY = "GStreamer AML AVsink plugin"
#  Amlogic GStreamer plugins to send audio es to aml dsp and video es to aml hw decoder. 
#  decode and render will be complete at kernel level.
SECTION = "multimedia"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
PACKAGE_ARCH = "${MACHINE_ARCH}"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

inherit autotools pkgconfig

DEPENDS = "gstreamer libamcodec libamavutils"
DEPENDS_alien5 = "gstreamer linkdroid-libamcodec-${MACHINE} linkdroid-libamavutils-${MACHINE}"
DEPENDS_k1pro = "gstreamer linkdroid-libamcodec-alien5 linkdroid-libamavutils-alien5"
DEPENDS_k2pro = "gstreamer linkdroid-libamcodec-alien5 linkdroid-libamavutils-alien5"
DEPENDS_k3pro = "gstreamer linkdroid-libamcodec-alien5 linkdroid-libamavutils-alien5"
DEPENDS_k1plus = "gstreamer linkdroid-libamcodec-alien5 linkdroid-libamavutils-alien5"

SRC_URI = "file://gst-aml-plugins-0.11.0.zip \
           file://osd_fix.patch \
"

S = "${WORKDIR}/gst-aml-plugins-0.11.0"

CFLAGS += " -O2 -fPIC -I${S}/common/include  -I${S}/common/include/amports  -I${S}/common/include/ppmgr \
    -I${STAGING_INCDIR} -I${S}/common/amstreaminfo -I${S}/common/amlsysctl  "
LDFLAGS =+ " -L${STAGING_LIBDIR} -L${STAGING_BASELIBDIR} "

FILES_${PN} += "${libdir}/* ${libdir}/libcommon.a"
FILES_${PN}-dbg += "${libdir}/gstreamer-0.10/.debug $"
FILES_${PN}-dev += "${S}/include/* "
