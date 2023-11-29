#ifndef SHAMROCK_JNIHELPER_H
#define SHAMROCK_JNIHELPER_H

#include "jni.h"
#include "android/log.h"

namespace JNIHelper {
    JNIEnv *getJNIEnv(JavaVM * jvm, int *attach);

    jint delJNIEnv(JavaVM * jvm);
}


#endif //SHAMROCK_JNIHELPER_H
