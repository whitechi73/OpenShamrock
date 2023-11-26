#include <jni.h>
#include "anti_detection/anti_detection.h"
#include "helper/lsposed.h"
#include "jnihelper.h"

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