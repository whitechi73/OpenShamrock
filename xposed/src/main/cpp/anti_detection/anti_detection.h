#ifndef SHAMROCK_ANTI_DETECTION_H
#define SHAMROCK_ANTI_DETECTION_H

#include <vector>
#include <string>
#include <initializer_list>
#include "lsposed.h"
#include "jnihelper.h"

static HookFunType hook_function = nullptr;

static std::vector<std::string> qemu_detect_props = {
        "init.svc.qemu-props", "qemu.hw.mainkeys", "qemu.sf.fake_camera", "ro.kernel.android.qemud",
        "qemu.sf.lcd_density", "init.svc.qemud", "ro.kernel.qemu",
        "libc.debug.malloc"
};

#endif //SHAMROCK_ANTI_DETECTION_H
