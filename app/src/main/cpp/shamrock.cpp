#include <jni.h>
#include <cstdio>
#include <cstdlib>
#include <cstring>
#include <iostream>
#include <filesystem>
#include <random>
#include <android/log.h>
#include <sys/time.h>

#include "md5.h"

extern "C"
JNIEXPORT jstring JNICALL
Java_moe_fuqiuluo_shamrock_xposed_actions_PullConfig_testNativeLibrary(JNIEnv *env, jobject thiz) {
    return env->NewStringUTF("加载Shamrock库成功~");
}

extern "C"
JNIEXPORT jstring JNICALL
Java_moe_fuqiuluo_shamrock_utils_MD5_genFileMd5Hex(JNIEnv *env, jobject thiz, jstring file_path) {
    auto cPathStr = env->GetStringUTFChars(file_path, nullptr);
    std::filesystem::path filePath(cPathStr);
    if (!std::filesystem::exists(filePath)) {
        jclass exClass = env->FindClass("java/io/FileNotFoundException");
        env->ThrowNew(exClass, "目标文件不存在");
        env->DeleteLocalRef(exClass);
        return nullptr;
    }
    auto file = std::ifstream(filePath.c_str(), std::ios::binary);
    MD5 md5;
    md5.update(file);
    auto md5Hex = md5.toString();

    env->ReleaseStringUTFChars(file_path, cPathStr);

    return env->NewStringUTF(md5Hex.c_str());
}

extern "C"
JNIEXPORT jstring JNICALL
Java_moe_fuqiuluo_shamrock_utils_MD5_getMd5Hex(JNIEnv *env, jobject thiz, jbyteArray bytes) {
    auto len = env->GetArrayLength(bytes);
    auto *cBytes = new unsigned char[len];
    env->GetByteArrayRegion(bytes, 0, len, reinterpret_cast<jbyte *>(cBytes));

    MD5 md5;
    md5.update(cBytes, len);
    auto md5Hex = md5.toString();

    delete[] cBytes;

    return env->NewStringUTF(md5Hex.c_str());
}