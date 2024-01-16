#include <jni.h>
#include "anti_detection/anti_detection.h"
#include "helper/lsposed.h"
#include "jnihelper.h"

static JavaVM *global_jvm = nullptr;
static HookFunType hook_function = nullptr;

extern "C" [[gnu::visibility("default")]] [[gnu::used]]
jint JNI_OnLoad(JavaVM *jvm, void*) {
    global_jvm = jvm;
    int attach = 0;
    JNIEnv *env = JNIHelper::getJNIEnv(jvm, &attach);

    // do something
    LOGI("[Shamrock] JNI_OnLoad NativeModule Init: %p", env);

    if (attach == 1) {
        JNIHelper::delJNIEnv(jvm);
    }

    //hook_function((void *)env->functions->FindClass, (void *)fake_FindClass, (void **)&backup_FindClass);
    return JNI_VERSION_1_6;
}

extern "C"
JNIEXPORT jboolean JNICALL
Java_moe_fuqiuluo_shamrock_xposed_XposedEntry_00024Companion_injected(JNIEnv *env, jobject thiz) {
    LOGI("[Shamrock] injected: %p", hook_function);
    return hook_function != nullptr;
}

extern "C"
JNIEXPORT jboolean JNICALL
Java_moe_fuqiuluo_shamrock_xposed_XposedEntry_00024Companion_hasEnv(JNIEnv *env, jobject thiz) {
    LOGI("[Shamrock] hasEnv: %p", global_jvm);
    return global_jvm != nullptr;
}

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
                || strstr(value, "nox") //部分NoxAppPlayer
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

    const char* emuSpecFile[] = {
        "libhoudini.so",
        "libndk.so",
        "libnoxd.so",    //NoxAppPlayer
        "libnoxspeedup.so",    //NoxAppPlayer
        "nox-prop",    //NoxAppPlayer (MayUseless?)
        "nox-vbox-sf",    //NoxAppPlayer (MayUseless?)
        "noxd",    //NoxAppPlayer (MayUseless?)
        "noxspeedup",    //NoxAppPlayer (MayUseless?)
    };
    for (const char* keyword : emuSpecFile) {
        if (strstr(filename, keyword)) {
            LOGI("[Shamrock] bypass emu detection");
            return nullptr;
        }
    }

    if (strstr(filename, "libdobby.so")) {
        LOGI("[Shamrock] bypass dobby detection");
        return nullptr;
    }
    return backup_fopen(filename, mode);
}

char * __cdecl my_strstr(const char *lhs, const char *rhs) {
    char *cur = (char *)lhs;
    char *l;
    char *r;
    if (!*rhs) {
        return ((char *)lhs);
    }
    while (*cur) {
        l = cur;
        r = (char *)rhs;
        while (*r && !(*l - *r)) {
            l++;
            r++;
        }
        if (!*r) {
            return cur;
        }
        cur++;
    }
    return nullptr;
}

int fake_memcmp(const void* __lhs, const void* __rhs, size_t __n) {
    //if (my_strstr((const char*) __rhs, "lsposed")) {
        //return -1;
    //}
    //if (my_strstr((const char*) __rhs, "xposed")) {
    //    return -1;
    //}
    if (my_strstr((const char*) __rhs, "shamrock")) {
        if (backup_memcmp(__lhs, __rhs, __n) == 0) {
            // 底层广播判断
            return 0;
        }
        return -1;
    }
    if (my_strstr((const char*) __rhs, "riru")) {
        return -1;
    }
    //if (my_strstr((const char*) __rhs, "zygisk")) {
    //    return -1;
    //}
    //if (my_strstr((const char*) __rhs, "magisk")) {
    //    return -1;
    //}
    return backup_memcmp(__lhs, __rhs, __n);
}

void on_library_loaded(const char *name, void *handle) {

}

extern "C" [[gnu::visibility("default")]] [[gnu::used]]
NativeOnModuleLoaded native_init(const NativeAPIEntries *entries) {
    hook_function = entries->hook_func;
    LOGI("[Shamrock] LSPosed NativeModule Init: %p", hook_function);

    return on_library_loaded;
}

extern "C"
JNIEXPORT jboolean JNICALL
Java_moe_fuqiuluo_shamrock_xposed_actions_AntiDetection_antiNativeDetections(JNIEnv *env,
                                                                             jobject thiz) {
    if (hook_function == nullptr) return false;
    hook_function((void*) __system_property_get, (void *)fake_system_property_get, (void **) &backup_system_property_get);
    hook_function((void*) fopen, (void*) fake_fopen, (void**) &backup_fopen);
    //hook_function((void*) strstr, (void*) fake_strstr, (void**) &backup_strstr);
    hook_function((void*) memcmp, (void*) fake_memcmp, (void**) &backup_memcmp);

    return true;
}
