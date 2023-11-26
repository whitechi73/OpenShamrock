#include "jnihelper.h"

void JNIHelper::initJavaVM(JavaVM *jvm) {
    global_jvm = jvm;
}

JNIEnv *JNIHelper::getJNIEnv(int *attach) {
    if (global_jvm == NULL) return NULL;

    *attach = 0;
    JNIEnv *jni_env = NULL;

    int status = global_jvm->GetEnv((void **)&jni_env, JNI_VERSION_1_6);

    if (status == JNI_EDETACHED || jni_env == NULL) {
        status = global_jvm->AttachCurrentThread(&jni_env, NULL);
        if (status < 0) {
            jni_env = NULL;
        } else {
            *attach = 1;
        }
    }
    return jni_env;
}

jint JNIHelper::delJNIEnv() {
    if (global_jvm == nullptr) return 0;
    return global_jvm->DetachCurrentThread();
}

