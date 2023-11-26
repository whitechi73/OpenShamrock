#ifndef SHAMROCK_JNIHELPER_H
#define SHAMROCK_JNIHELPER_H

#include "jni.h"
#include "android/log.h"

namespace JNIHelper {
    static JavaVM *global_jvm = nullptr;

    void initJavaVM(JavaVM *jvm);

    JNIEnv *getJNIEnv(int *attach);

    jint delJNIEnv();
}


#endif //SHAMROCK_JNIHELPER_H
