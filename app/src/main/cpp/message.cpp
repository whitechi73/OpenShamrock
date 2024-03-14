#include "jni.h"
#include <random>

inline void replace_string(std::string& str, const std::string& from, const std::string& to) {
    size_t startPos = 0;
    while ((startPos = str.find(from, startPos)) != std::string::npos) {
        str.replace(startPos, from.length(), to);
        startPos += to.length();
    }
}

extern "C"
JNIEXPORT jlong JNICALL
Java_qq_service_msg_MessageHelper_createMessageUniseq(JNIEnv *env, jobject thiz,
                                                               jint chat_type,
                                                               jlong time) {
    static std::random_device rd;
    static std::mt19937 generator(rd());
    static std::uniform_int_distribution<int> distribution(INT32_MIN, INT32_MAX);
    int64_t uniseq = (time / 1000) << (8 * 4);
    auto msgtype = (int64_t) chat_type;
    int64_t random = abs(distribution(generator)) & 0xffffff00L;
    return uniseq | random | msgtype;
}


extern "C"
JNIEXPORT jint JNICALL
Java_moe_fuqiuluo_shamrock_helper_MessageHelper_getChatType(JNIEnv *env, jobject thiz,
                                                       jlong msg_id) {
    return (int32_t) ((int64_t) msg_id & 0xffL);
}

extern "C"
JNIEXPORT jlong JNICALL
Java_moe_fuqiuluo_shamrock_helper_MessageHelper_insertChatTypeToMsgId(JNIEnv *env, jobject thiz,
                                                                     jlong msg_id, jint chat_type) {
    return (msg_id & 0xffffffffffffff00L) | chat_type;
}