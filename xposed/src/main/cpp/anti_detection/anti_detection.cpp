#include "anti_detection.h"

int (*backup_system_property_get)(const char *name, char *value);
FILE* (*backup_fopen)(const char *filename, const char *mode);

int fake_system_property_get(const char *name, char *value) {
    for (auto &prop: qemu_detect_props) {
        if (strstr(name, prop.c_str())) {
            LOGI("[Shamrock] bypass qemu detection");
            value[0] = 0;
            return 0;
        }
    }

    if (strstr(name, "ro.debuggable")
        || strstr(name, "ro.kernel.qemu.gles")
        || strstr(name, "debug.atrace.tags.enableflags")) {
        strcpy(value, "0");
        return 1;
    }

    if (strstr(name, "ro.product.cpu.abilist")) {
        int len = backup_system_property_get(name, value);
        if (len > 0) {
            if (strstr(value, "x86")) {
                strcpy(value, "arm64-v8a,armeabi-v7a,armeabi");
                return 29;
            }
        }
        return len;
    }

    if (strstr(name, "ro.hardware")) {
        int len = backup_system_property_get(name, value);
        if (len > 0) {
            if (strstr(value, "generic")
                || strstr(value, "unknown")
                || strstr(value, "emulator")
                || strstr(value, "vbox")
                || strstr(value, "genymotion")
                || strstr(value, "goldfish")) {
                strcpy(value, "qcom");
                return 4;
            }
        }
        return len;
    }

    //LOGI("[Shamrock] fake_system_property_get(%s)", name);
    return backup_system_property_get(name, value);
}

FILE* fake_fopen(const char *filename, const char *mode) {
    if (strstr(filename, "qemu_pipe")) {
        LOGI("[Shamrock] bypass qemu detection");
        return nullptr;
    }

    if (strstr(filename, "libhoudini.so")) {
        LOGI("[Shamrock] bypass emu detection");
        return nullptr;
    }

    return backup_fopen(filename, mode);
}

void on_library_loaded(const char *name, void *handle) {

}

extern "C" [[gnu::visibility("default")]] [[gnu::used]]
NativeOnModuleLoaded native_init(const NativeAPIEntries *entries) {
    hook_function = entries->hook_func;
    LOGI("[Shamrock] LSPosed NativeModule Init: %p", hook_function);

    hook_function((void*) __system_property_get, (void *)fake_system_property_get, (void **) &backup_system_property_get);
    hook_function((void*) fopen, (void*) fake_fopen, (void**) &backup_fopen);

    return on_library_loaded;
}
