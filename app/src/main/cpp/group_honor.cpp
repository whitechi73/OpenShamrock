#include "jni.h"
#include <vector>
#include <string>
#include <algorithm>

struct Honor {
    int id;
    std::string name;
    std::string icon_url;
    int priority;
};

int calc_honor_flag(int honor_id, char honor_flag);

jobject make_honor_object(JNIEnv *env, jobject user_id, const Honor& honor);


extern "C"
JNIEXPORT jobject JNICALL
Java_moe_fuqiuluo_shamrock_remote_action_handlers_GetTroopHonor_nativeDecodeHonor(JNIEnv *env, jobject thiz,
                                                                         jstring user_id,
                                                                         jint honor_id,
                                                                         jbyte honor_flag) {
    static std::vector<Honor> honor_list = {
            Honor{1, "龙王", "https://qzonestyle.gtimg.cn/aoi/sola/20200213150116_n4PxCiurbm.png", 1},
            Honor{2, "群聊之火", "https://qzonestyle.gtimg.cn/aoi/sola/20200217190136_92JEGFKC5k.png", 3},
            Honor{3, "群聊炽焰", "https://qzonestyle.gtimg.cn/aoi/sola/20200217190204_zgCTeSrMq1.png", 4},
            Honor{5, "冒尖小春笋", "https://qzonestyle.gtimg.cn/aoi/sola/20200213150335_tUJCAtoKVP.png", 5},
            Honor{6, "快乐源泉", "https://qzonestyle.gtimg.cn/aoi/sola/20200213150434_3tDmsJExCP.png", 7},
            Honor{7, "学术新星", "https://sola.gtimg.cn/aoi/sola/20200515140645_j0X6gbuHNP.png", 8},
            Honor{8, "顶尖学霸", "https://sola.gtimg.cn/aoi/sola/20200515140639_0CtWOpfVzK.png", 9},
            Honor{9, "至尊学神", "https://sola.gtimg.cn/aoi/sola/20200515140628_P8UEYBjMBT.png", 10},
            Honor{10, "一笔当先", "https://sola.gtimg.cn/aoi/sola/20200515140654_4r94tSCdaB.png", 11},
            Honor{11, "奋进小翠竹", "https://sola.gtimg.cn/aoi/sola/20200812151819_wbj6z2NGoB.png", 6},
            Honor{12, "氛围魔杖", "https://sola.gtimg.cn/aoi/sola/20200812151831_4ZJgQCaD1H.png", 2},
            Honor{13, "壕礼皇冠", "https://sola.gtimg.cn/aoi/sola/20200930154050_juZOAMg7pt.png", 12},
    };
    int flag = calc_honor_flag(honor_id, honor_flag);
    if ((honor_id != 1 && honor_id != 2 && honor_id != 3) || flag != 1) {
        auto honor = *std::find_if(honor_list.begin(), honor_list.end(), [&honor_id](auto &honor) {
            return honor.id == honor_id;
        });
        return make_honor_object(env, user_id, honor);
    } else {
        auto honor = *std::find_if(honor_list.begin(), honor_list.end(), [&honor_id](auto &honor) {
            return honor.id == honor_id;
        });
        std::string url = "https://static-res.qq.com/static-res/groupInteract/vas/a/" + std::to_string(honor_id) + "_1.png";
        honor = Honor{honor_id, honor.name, url, honor.priority};
        return make_honor_object(env, user_id, honor);
    }
}

int calc_honor_flag(int honor_id, char honor_flag) {
    int flag;
    if (honor_flag == 0) {
        return 0;
    }
    if (honor_id == 1) {
        flag = honor_flag;
    } else if (honor_id == 2 || honor_id == 3) {
        flag = honor_flag >> 2;
    } else if (honor_id != 4) {
        return 0;
    } else {
        flag = honor_flag >> 4;
    }
    return flag & 3;
}

jobject make_honor_object(JNIEnv *env, jobject user_id, const Honor& honor) {
    jclass GroupMemberHonor = env->FindClass("moe/fuqiuluo/shamrock/remote/service/data/GroupMemberHonor");
    jmethodID GroupMemberHonor_init = env->GetMethodID(GroupMemberHonor, "<init>",
                                                       "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V");
    auto user_id_str = (jstring) user_id;
    jstring honor_desc = env->NewStringUTF(honor.name.c_str());
    jstring uin_name = env->NewStringUTF("");
    jstring honor_icon_url = env->NewStringUTF(honor.icon_url.c_str());
    jobject ret = env->NewObject(GroupMemberHonor, GroupMemberHonor_init, user_id_str, uin_name, honor_icon_url, 0, honor.id, honor_desc);

    env->DeleteLocalRef(GroupMemberHonor);
    env->DeleteLocalRef(user_id_str);
    env->DeleteLocalRef(honor_desc);
    env->DeleteLocalRef(honor_icon_url);

    return ret;
}
