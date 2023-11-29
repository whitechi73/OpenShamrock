#include "jnihelper.h"

JNIEnv *JNIHelper::getJNIEnv(JavaVM * jvm, int *attach) {
    if (jvm == NULL) return NULL;

    *attach = 0;
    JNIEnv *jni_env = NULL;

    int status = jvm->GetEnv((void **)&jni_env, JNI_VERSION_1_6);

    if (status == JNI_EDETACHED || jni_env == NULL) {
        status = jvm->AttachCurrentThread(&jni_env, NULL);
        if (status < 0) {
            jni_env = NULL;
        } else {
            *attach = 1;
        }
    }
    return jni_env;
}

jint JNIHelper::delJNIEnv(JavaVM * jvm) {
    if (jvm == nullptr) return 0;
    return jvm->DetachCurrentThread();
}

