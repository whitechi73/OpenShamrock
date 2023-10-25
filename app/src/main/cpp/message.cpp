#include "jni.h"
#include "cqcode.h"
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
Java_moe_fuqiuluo_shamrock_helper_MessageHelper_createMessageUniseq(JNIEnv *env, jobject thiz,
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
JNIEXPORT jobject JNICALL
Java_moe_fuqiuluo_shamrock_helper_MessageHelper_nativeDecodeCQCode(JNIEnv *env, jobject thiz,
                                                              jstring code) {
    jclass ArrayList = env->FindClass("java/util/ArrayList");
    jmethodID NewArrayList = env->GetMethodID(ArrayList, "<init>", "()V");
    jmethodID ArrayListAdd = env->GetMethodID(ArrayList, "add", "(Ljava/lang/Object;)Z");
    jobject arrayList = env->NewObject(ArrayList, NewArrayList);

    const char* cCode = env->GetStringUTFChars(code, nullptr);
    std::string cppCode = cCode;
    std::vector<std::unordered_map<std::string, std::string>> dest;
    try {
        decode_cqcode(cppCode, dest);
    } catch (illegal_code& code) {
        return arrayList;
    }

    jclass HashMap = env->FindClass("java/util/HashMap");
    jmethodID NewHashMap = env->GetMethodID(HashMap, "<init>", "()V");
    jclass String = env->FindClass("java/lang/String");
    jmethodID NewString = env->GetMethodID(String, "<init>", "([BLjava/lang/String;)V");
    jstring charset = env->NewStringUTF("UTF-8");
    jmethodID put = env->GetMethodID(HashMap, "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;");
    for (auto& map : dest) {
        jobject hashMap = env->NewObject(HashMap, NewHashMap);
        for (const auto& pair : map) {
            jbyteArray keyArray = env->NewByteArray((int) pair.first.size());
            jbyteArray valueArray = env->NewByteArray((int) pair.second.size());
            env->SetByteArrayRegion(keyArray, 0, (int) pair.first.size(), (jbyte*)pair.first.c_str());
            env->SetByteArrayRegion(valueArray, 0, (int) pair.second.size(), (jbyte*)pair.second.c_str());
            auto key = (jstring) env->NewObject(String, NewString, keyArray, charset);
            auto value = (jstring) env->NewObject(String, NewString, valueArray, charset);
            env->CallObjectMethod(hashMap, put, key, value);
        }
        env->CallBooleanMethod(arrayList, ArrayListAdd, hashMap);
    }

    env->DeleteLocalRef(ArrayList);
    env->DeleteLocalRef(HashMap);
    env->DeleteLocalRef(String);
    env->DeleteLocalRef(charset);
    env->ReleaseStringUTFChars(code, cCode);

    return arrayList;
}

extern "C"
JNIEXPORT jstring JNICALL
Java_moe_fuqiuluo_shamrock_helper_MessageHelper_nativeEncodeCQCode(JNIEnv *env, jobject thiz,
                                                              jobject segment_list) {
    jclass List = env->FindClass("java/util/List");
    jmethodID ListSize = env->GetMethodID(List, "size", "()I");
    jmethodID ListGet = env->GetMethodID(List, "get", "(I)Ljava/lang/Object;");
    jclass Map = env->FindClass("java/util/Map");
    jmethodID MapGet = env->GetMethodID(Map, "get", "(Ljava/lang/Object;)Ljava/lang/Object;");
    jmethodID entrySetMethod = env->GetMethodID(Map, "entrySet", "()Ljava/util/Set;");
    jclass setClass = env->FindClass("java/util/Set");
    jmethodID iteratorMethod = env->GetMethodID(setClass, "iterator", "()Ljava/util/Iterator;");
    jclass entryClass = env->FindClass("java/util/Map$Entry");
    jmethodID getKeyMethod = env->GetMethodID(entryClass, "getKey", "()Ljava/lang/Object;");
    jmethodID getValueMethod = env->GetMethodID(entryClass, "getValue", "()Ljava/lang/Object;");

    std::string result;
    jint size = env->CallIntMethod(segment_list, ListSize);
    for (int i = 0; i < size; i++ ) {
        jobject segment = env->CallObjectMethod(segment_list, ListGet, i);
        jobject entrySet = env->CallObjectMethod(segment, entrySetMethod);
        jobject iterator = env->CallObjectMethod(entrySet, iteratorMethod);
        auto type = (jstring) env->CallObjectMethod(segment, MapGet, env->NewStringUTF("_type"));
        auto typeString = env->GetStringUTFChars(type, nullptr);
        if (strcmp(typeString, "text") == 0) {
            auto text = (jstring) env->CallObjectMethod(segment, MapGet, env->NewStringUTF("text"));
            auto textString = env->GetStringUTFChars(text, nullptr);
            std::string tmpValue = textString;
            replace_string(tmpValue, "&", "&amp;");
            replace_string(tmpValue, "[", "&#91;");
            replace_string(tmpValue, "]", "&#93;");
            replace_string(tmpValue, ",", "&#44;");
            result.append(tmpValue);
            env->ReleaseStringUTFChars(text, textString);
        } else {
            result.append("[CQ:");
            result.append(typeString);
            while (env->CallBooleanMethod(iterator, env->GetMethodID(env->GetObjectClass(iterator), "hasNext", "()Z"))) {
                jobject entry = env->CallObjectMethod(iterator, env->GetMethodID(env->GetObjectClass(iterator), "next", "()Ljava/lang/Object;"));
                auto key = (jstring) env->CallObjectMethod(entry, getKeyMethod);
                auto value = (jstring) env->CallObjectMethod(entry, getValueMethod);
                auto keyString = env->GetStringUTFChars(key, nullptr);
                auto valueString = env->GetStringUTFChars(value, nullptr);
                if (strcmp(keyString, "_type") != 0) {
                    std::string tmpValue = valueString;
                    replace_string(tmpValue, "&", "&amp;");
                    replace_string(tmpValue, "[", "&#91;");
                    replace_string(tmpValue, "]", "&#93;");
                    replace_string(tmpValue, ",", "&#44;");
                    result.append(",").append(keyString).append("=").append(tmpValue);
                }
                env->ReleaseStringUTFChars(key, keyString);
                env->ReleaseStringUTFChars(value, valueString);
                env->DeleteLocalRef(entry);
                env->DeleteLocalRef(key);
                env->DeleteLocalRef(value);
            }
            result.append("]");
        }
        env->ReleaseStringUTFChars(type, typeString);
    }

    env->DeleteLocalRef(List);
    env->DeleteLocalRef(Map);
    env->DeleteLocalRef(setClass);
    env->DeleteLocalRef(entryClass);
    return env->NewStringUTF(result.c_str());
}


extern "C"
JNIEXPORT jlong JNICALL
Java_moe_fuqiuluo_shamrock_helper_MessageHelper_insertChatTypeToMsgId(JNIEnv *env, jobject thiz,
                                                                     jlong msg_id, jint chat_type) {
    return (msg_id & 0xffffffffffffff00L) | chat_type;
}