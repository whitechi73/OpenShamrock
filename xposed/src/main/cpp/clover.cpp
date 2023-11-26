#include <jni.h>
#include <string>
#include <utility>
#include <initializer_list>
#include <vector>
#include <sys/auxv.h>
#include <android/log.h>
#include <dlfcn.h>
#include <string_view>
#include "lsposed.h"
#include "jnihelper.h"

static HookFunType hook_function = nullptr;

static std::vector<std::string> qemu_detect_props = {
        "init.svc.qemu-props", "qemu.hw.mainkeys", "qemu.sf.fake_camera", "ro.kernel.android.qemud",
        "qemu.sf.lcd_density", "init.svc.qemud", "ro.kernel.qemu",
        "libc.debug.malloc"
};

int (*backup_system_property_get)(const char *name, char *value);

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

void on_library_loaded(const char *name, void *handle) {
    auto libraryName = std::string(name);
    if (libraryName.ends_with("libc.so") || libraryName.ends_with("libfekit.so")) {
        void *target = dlsym(handle, "__system_property_get");
        if (target != nullptr) {
            hook_function(target, (void *)fake_system_property_get, (void **) &backup_system_property_get);
        } else {
            LOGE("[Shamrock] failed to hook __system_property_get");
        }
    }
}

extern "C" [[gnu::visibility("default")]] [[gnu::used]]
jint JNI_OnLoad(JavaVM *jvm, void*) {
    JNIHelper::initJavaVM(jvm);
    int attach = 0;
    JNIEnv *env = JNIHelper::getJNIEnv(&attach);

    // do something
    LOGI("[Shamrock] JNI_OnLoad NativeModule Init: %p", env);

    if (attach == 1) {
        JNIHelper::delJNIEnv();
    }

    //hook_function((void *)env->functions->FindClass, (void *)fake_FindClass, (void **)&backup_FindClass);
    return JNI_VERSION_1_6;
}

extern "C" [[gnu::visibility("default")]] [[gnu::used]]
NativeOnModuleLoaded native_init(const NativeAPIEntries *entries) {
    hook_function = entries->hook_func;
    LOGI("[Shamrock] LSPosed NativeModule Init: %p", hook_function);
    return on_library_loaded;
}

extern "C"
JNIEXPORT jboolean JNICALL
Java_moe_fuqiuluo_shamrock_xposed_XposedEntry_00024Companion_injected(JNIEnv *env, jobject thiz) {
    return hook_function != nullptr;
}

extern "C"
JNIEXPORT jboolean JNICALL
Java_moe_fuqiuluo_shamrock_xposed_XposedEntry_00024Companion_hasEnv(JNIEnv *env, jobject thiz) {
    return JNIHelper::global_jvm != nullptr;
}