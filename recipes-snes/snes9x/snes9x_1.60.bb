SUMMARY = "Multi-platform Super Nintendo emulator"
HOMEPAGE = "http://www.snes9x.com/"
SECTION = "emulators"

LICENSE = "GPLv2 & LGPLv2.1"
LIC_FILES_CHKSUM = "\
	file://../jma/license.txt;md5=86ecd516a6a0002a9d0db93c8bac0f07 \
        file://../filter/snes_ntsc-license.txt;md5=fbc093901857fcd118f065f900982c24 \
        file://../filter/xbrz-license.txt;md5=9eef91148a9b14ec7f9df333daebc746 \
	"

SRC_URI = "\
	git://github.com/snes9xgit/snes9x.git;protocol=https;tag=${PV} \
	file://cross_compile.patch;striplevel=2 \
	"

S = "${WORKDIR}/git/unix"

inherit autotools-brokensep

DEPENDS = "\
	libice \
	libpng \
	libsm \
	libx11 \
	libxext \
	libxv \
	pkgconfig \
	zlib \
	"

TARGET_CC_ARCH += "${LDFLAGS}"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 snes9x ${D}${bindir}
}
