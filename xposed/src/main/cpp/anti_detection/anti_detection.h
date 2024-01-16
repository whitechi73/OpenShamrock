#ifndef SHAMROCK_ANTI_DETECTION_H
#define SHAMROCK_ANTI_DETECTION_H

#include <vector>
#include <string>
#include <initializer_list>
#include "lsposed.h"
#include "jnihelper.h"

static std::vector<std::string> qemu_detect_props = {
        "init.svc.qemu-props", "qemu.hw.mainkeys", "qemu.sf.fake_camera", "ro.kernel.android.qemud",
        "qemu.sf.lcd_density", "init.svc.qemud", "ro.kernel.qemu",
        "libc.debug.malloc"
};

static int (*backup_system_property_get)(const char *name, char *value);
static FILE* (*backup_fopen)(const char *filename, const char *mode);
static int (*backup_memcmp)(const void* __lhs, const void* __rhs, size_t __n);
//static const char* (*backup_strstr)(const char* h, const char* n);

//int fake_system_property_get(const char *name, char *value);
//FILE* fake_fopen(const char *filename, const char *mode);

//void on_library_loaded(const char *name, void *handle);

#endif //SHAMROCK_ANTI_DETECTION_H
