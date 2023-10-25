package com.tencent.mobileqq.data;

import org.json.JSONObject;

import java.util.ArrayList;

public class MessageRecord {
    public static final int EXTRA_STREAM_PTT_FLAG = 10001;
    public static final int MIN_VERSION_CODE_SUPPORT_IMAGE_MD5_TRANS = 2;
    private static final long MSG_SEQ_CRITICAL_VAL = 100000000000000L;
    public static final int MSG_TYPE_0X7F = -2006;
    public static final int MSG_TYPE_ACTIVATE_FRIENDS = -5003;
    public static final int MSG_TYPE_ACTIVITY = -4002;
    public static final int MSG_TYPE_AIO_FOR_LOCATION_SHARE = -2076;
    public static final int MSG_TYPE_AIO_FOR_STORY_VIDEO = -2074;
    public static final int MSG_TYPE_AI_SPECIAL_GUIDE = -1052;
    public static final int MSG_TYPE_APPROVAL_GRAY_TIPS = -2041;
    public static final int MSG_TYPE_APPROVAL_MSG = -2040;
    public static final int MSG_TYPE_ARK_APP = -5008;
    public static final int MSG_TYPE_ARK_BABYQ_REPLY = -5016;
    public static final int MSG_TYPE_ARK_SDK_SHARE = -5017;
    public static final int MSG_TYPE_AUTHORIZE_FAILED = -4005;
    public static final int MSG_TYPE_AUTOREPLY = -10000;
    public static final int MSG_TYPE_BAT_PROCESS_FILE = -3013;
    public static final int MSG_TYPE_BIRTHDAY_NOTICE = -7007;
    public static final int MSG_TYPE_BIZ_DATA = -2023;
    public static final int MSG_TYPE_C2C_CHAT_FREQ_CALL_TIP = -1014;
    public static final int MSG_TYPE_C2C_KEYWORD_CALL_TIP = -1015;
    public static final int MSG_TYPE_C2C_MIXED = -30002;
    public static final int MSG_TYPE_CMGAME_TIPS = -7004;
    public static final int MSG_TYPE_COLOR_RING_TIPS = -3012;
    public static final int MSG_TYPE_COMMON_HOBBY_FOR_AIO_SHOW = -2023;
    public static final int MSG_TYPE_CONFESS_CARD = -2066;
    public static final int MSG_TYPE_CONFESS_NEWS = -2065;
    public static final int MSG_TYPE_CONFIGURABLE_GRAY_TIPS = 2024;
    public static final int MSG_TYPE_CONFIGURABLE_TAB_VISIBLE_GRAY_TIPS = -2042;
    public static final int MSG_TYPE_DAREN_ASSISTANT = -2068;
    public static final int MSG_TYPE_DATE_FEED = -1042;
    public static final int MSG_TYPE_DEVICE_CLOSEGROUPCHAT = -4506;
    public static final int MSG_TYPE_DEVICE_DISMISSBIND = -4507;
    public static final int MSG_TYPE_DEVICE_FILE = -4500;
    public static final int MSG_TYPE_DEVICE_LITTLE_VIDEO = -4509;
    public static final int MSG_TYPE_DEVICE_OPENGROUPCHAT = -4505;
    public static final int MSG_TYPE_DEVICE_PTT = -4501;
    public static final int MSG_TYPE_DEVICE_SHORT_VIDEO = -4503;
    public static final int MSG_TYPE_DEVICE_SINGLESTRUCT = -4502;
    public static final int MSG_TYPE_DEVICE_TEXT = -4508;
    public static final int MSG_TYPE_DINGDONG_SCHEDULE_MSG = -5010;
    public static final int MSG_TYPE_DING_DONG_GRAY_TIPS = -2034;
    public static final int MSG_TYPE_DISCUSS_PUSH = -1004;
    public static final int MSG_TYPE_DISCUSS_TO_TROOP_TIP = -7091;
    public static final int MSG_TYPE_DISCUSS_UPGRADE_TO_GROUP_TIPS = -1050;
    public static final int MSG_TYPE_DISC_CREATE_CALL_TIP = -1016;
    public static final int MSG_TYPE_DISC_PTT_FREQ_CALL_TIP = -1017;
    public static final int MSG_TYPE_ENTER_TROOP = -4003;
    public static final int MSG_TYPE_FAILED_MSG = -2013;
    public static final int MSG_TYPE_FAKE_EMOTION = -7008;
    public static final int MSG_TYPE_FILE_RECEIPT = -3008;
    public static final int MSG_TYPE_FLASH_CHAT = -5013;
    public static final int MSG_TYPE_FOLD_MSG_GRAY_TIPS = -5011;
    public static final int MSG_TYPE_FORWARD_IMAGE = -20000;
    public static final int MSG_TYPE_FRIEND_SYSTEM_STRUCT_MSG = -2050;
    public static final int MSG_TYPE_FU_DAI = -2072;
    public static final int MSG_TYPE_GAME_INVITE = -3004;
    public static final int MSG_TYPE_GAME_PARTY_GRAY_TIPS = -2049;
    public static final int MSG_TYPE_GAME_SHARE = -3005;
    public static final int MSG_TYPE_GRAY_DATALINE_TIM_TIPS = -5041;
    public static final int MSG_TYPE_GRAY_TIPS = -5000;
    public static final int MSG_TYPE_GRAY_TIPS_TAB_VISIBLE = -5001;
    public static final int MSG_TYPE_GROUPDISC_FILE = -2014;
    public static final int MSG_TYPE_GUILD_APP_CHANNEL = -4051;
    public static final int MSG_TYPE_GUILD_GIFT = -5009;
    public static final int MSG_TYPE_GUILD_GRAYTIP_NOT_ROAM = -4100;
    public static final int MSG_TYPE_GUILD_LIVE_GIFT = -4070;
    public static final int MSG_TYPE_GUILD_MARK_DOWN = -4052;
    public static final int MSG_TYPE_GUILD_MSG_NOTIFY_SETTING_TIPS = -4092;
    public static final int MSG_TYPE_GUILD_REVOKE_GRAY_TIP = -4050;
    public static final int MSG_TYPE_GUILD_ROBOT_BLACK_GRAY = -4089;
    public static final int MSG_TYPE_GUILD_ROBOT_DIRECT_MSG_LIMIT_TIPS = -4093;
    public static final int MSG_TYPE_GUILD_ROBOT_WELCOME_TIPS = -4090;
    public static final int MSG_TYPE_GUILD_SUBSCRIBE_CHANNEL_TIPS = -4091;
    public static final int MSG_TYPE_GUILD_WELCOME_TIPS = -4028;
    public static final int MSG_TYPE_GUILD_YOLO_GAME_RESULT = -4029;
    public static final int MSG_TYPE_GUILD_YOLO_SYSTEM = -4030;
    public static final int MSG_TYPE_GUILD_YOLO_TEAM = -4031;
    public static final int MSG_TYPE_HIBOOM = -5014;
    public static final int MSG_TYPE_HOMEWORK_PRAISE = -2043;
    public static final int MSG_TYPE_HONGBAO_KEYWORDS_TIPS = -1045;
    public static final int MSG_TYPE_HOT_CHAT_TO_SEE_TIP = 1018;
    public static final int MSG_TYPE_HR_INFO = -7003;
    public static final int MSG_TYPE_INCOMPATIBLE_GRAY_TIPS = -5002;
    public static final int MSG_TYPE_INTERACT_AND_FOLLOW = -2055;
    public static final int MSG_TYPE_LIFEONLINEACCOUNT = -5004;
    public static final int MSG_TYPE_LIGHTALK_MSG = -2026;
    public static final int MSG_TYPE_LIMIT_CHAT_CONFIRM = -7005;
    public static final int MSG_TYPE_LIMIT_CHAT_TOPIC = -4023;
    public static final int MSG_TYPE_LIMIT_CHAT_TOPIC_RECEIVER = -4024;
    public static final int MSG_TYPE_LOCAL_COMMON = -4000;
    public static final int MSG_TYPE_LOCAL_URL = -4001;
    public static final int MSG_TYPE_LONG_MIX = -1036;
    public static final int MSG_TYPE_LONG_TEXT = -1037;
    public static final int MSG_TYPE_MASTER_UIN_NAVIGATION = -2064;
    public static final int MSG_TYPE_MEDAL_NEWS = -2062;
    public static final int MSG_TYPE_MEDIA_EMO = -2001;
    public static final int MSG_TYPE_MEDIA_FILE = -2005;
    public static final int MSG_TYPE_MEDIA_LIGHTVIDEO = -2071;
    public static final int MSG_TYPE_MEDIA_MARKFACE = -2007;
    public static final int MSG_TYPE_MEDIA_MULTI09 = -2003;
    public static final int MSG_TYPE_MEDIA_MULTI513 = -2004;
    public static final int MSG_TYPE_MEDIA_PIC = -2000;
    public static final int MSG_TYPE_MEDIA_PTT = -2002;
    public static final int MSG_TYPE_MEDIA_SECRETFILE = -2008;
    public static final int MSG_TYPE_MEDIA_SHORTVIDEO = -2022;
    public static final int MSG_TYPE_MEDIA_VIDEO = -2009;
    public static final int MSG_TYPE_MEETING_NOTIFY = -5006;
    public static final int MSG_TYPE_MIX = -1035;
    public static final int MSG_TYPE_MULTI_TEXT_VIDEO = -4008;
    public static final int MSG_TYPE_MULTI_VIDEO = -2016;
    public static final int MSG_TYPE_MY_ENTER_TROOP = -4004;
    public static final int MSG_TYPE_NEARBY_DATING_SAFETY_TIP = -1028;
    public static final int MSG_TYPE_NEARBY_DATING_TIP = -1024;
    public static final int MSG_TYPE_NEARBY_FLOWER_TIP = -2037;
    public static final int MSG_TYPE_NEARBY_LIVE_TIP = -2053;
    public static final int MSG_TYPE_NEARBY_MARKET = -2027;
    public static final int MSG_TYPE_NEARBY_RECOMMENDER = -4011;
    public static final int MSG_TYPE_NEW_FRIEND_TIPS = -1013;
    public static final int MSG_TYPE_NEW_FRIEND_TIPS_GAME_ADDEE = -1019;
    public static final int MSG_TYPE_NEW_FRIEND_TIPS_GAME_ADDER = -1018;
    public static final int MSG_TYPE_NULL = -999;
    public static final int MSG_TYPE_ONLINE_FILE_REQ = -3007;
    public static final int MSG_TYPE_OPERATE_TIPS = -1041;
    public static final int MSG_TYPE_PA_PHONE_MSG_TIPS = -1048;
    public static final int MSG_TYPE_PC_PUSH = -3001;
    public static final int MSG_TYPE_PIC_AND_TEXT_MIXED = -3000;
    public static final int MSG_TYPE_PIC_QSECRETARY = -1032;
    public static final int MSG_TYPE_PL_NEWS = -2060;
    public static final int MSG_TYPE_POKE_EMO_MSG = -5018;
    public static final int MSG_TYPE_POKE_MSG = -5012;
    public static final int MSG_TYPE_PSTN_CALL = -2046;
    public static final int MSG_TYPE_PTT_QSECRETARY = -1031;
    public static final int MSG_TYPE_PUBLIC_ACCOUNT = -3006;
    public static final int MSG_TYPE_PUSH_REMINDER = -7090;
    public static final int MSG_TYPE_QCIRCLE_NEWEST_FEED = -2077;
    public static final int MSG_TYPE_QLINK_AP_CREATE_SUC_TIPS = -3011;
    public static final int MSG_TYPE_QLINK_FILE_TIPS = -3009;
    public static final int MSG_TYPE_QLINK_SEND_FILE_TIPS = -3010;
    public static final int MSG_TYPE_QQSTORY = -2051;
    public static final int MSG_TYPE_QQSTORY_COMMENT = -2052;
    public static final int MSG_TYPE_QQSTORY_LATEST_FEED = -2061;
    public static final int MSG_TYPE_QQWALLET_MSG = -2025;
    public static final int MSG_TYPE_QQWALLET_TIPS = -2029;
    public static final int MSG_TYPE_QZONE_NEWEST_FEED = -2015;
    public static final int MSG_TYPE_RECOMMAND_TIPS = -5007;
    public static final int MSG_TYPE_RED_PACKET_TIPS = -1044;
    public static final int MSG_TYPE_RENEWAL_TAIL_TIP = -4020;
    public static final int MSG_TYPE_REPLY_TEXT = -1049;
    public static final int MSG_TYPE_REVOKE_GRAY_TIPS = -2031;
    public static final int MSG_TYPE_SCRIBBLE_MSG = -7001;
    public static final int MSG_TYPE_SENSITIVE_MSG_MASK_TIPS = -1046;
    public static final int MSG_TYPE_SHAKE_WINDOW = -2020;
    public static final int MSG_TYPE_SHARE_HOT_CHAT_GRAY_TIPS = -2033;
    public static final int MSG_TYPE_SHARE_LBS_PUSH = -4010;
    public static final int MSG_TYPE_SHIELD_MSG = -2012;
    public static final int MSG_TYPE_SINGLE_WAY_FRIEND_ADD_ALLOW_ALL_MSG = -7006;
    public static final int MSG_TYPE_SINGLE_WAY_FRIEND_MSG = -2019;
    public static final int MSG_TYPE_SOUGOU_INPUT_TIPS = -1043;
    public static final int MSG_TYPE_SPECIALCARE_TIPS = -5005;
    public static final int MSG_TYPE_SPLIT_LINE_GRAY_TIPS = -4012;
    public static final int MSG_TYPE_STICKER_MSG = -2058;
    public static final int MSG_TYPE_STRUCT_LONG_TEXT = -1051;
    public static final int MSG_TYPE_STRUCT_MSG = -2011;
    public static final int MSG_TYPE_STRUCT_TROOP_NOTIFICATION = -2021;
    public static final int MSG_TYPE_SYSTEM_STRUCT_MSG = -2018;
    public static final int MSG_TYPE_TEAM_WORK_FILE_IMPORT_SUCCESS_TIPS = -2063;
    public static final int MSG_TYPE_TEAM_WORK_FILE_IMPORT_SUCCESS_TIPS_DL = -2073;
    public static final int MSG_TYPE_TEXT = -1000;
    public static final int MSG_TYPE_TEXT_FRIEND_FEED = -1034;
    public static final int MSG_TYPE_TEXT_GROUPMAN_ACCEPT = -1021;
    public static final int MSG_TYPE_TEXT_GROUPMAN_ADDREQUEST = -1020;
    public static final int MSG_TYPE_TEXT_GROUPMAN_INVITE = -1023;
    public static final int MSG_TYPE_TEXT_GROUPMAN_REFUSE = -1022;
    public static final int MSG_TYPE_TEXT_GROUP_CREATED = -1047;
    public static final int MSG_TYPE_TEXT_QSECRETARY = -1003;
    public static final int MSG_TYPE_TEXT_RECOMMEND_CIRCLE = -1033;
    public static final int MSG_TYPE_TEXT_RECOMMEND_CONTACT = -1030;
    public static final int MSG_TYPE_TEXT_RECOMMEND_TROOP = -1039;
    public static final int MSG_TYPE_TEXT_RECOMMEND_TROOP_BUSINESS = -1040;
    public static final int MSG_TYPE_TEXT_SAFE = -1002;
    public static final int MSG_TYPE_TEXT_SYSTEM_ACCEPT = -1008;
    public static final int MSG_TYPE_TEXT_SYSTEM_ACCEPTANDADD = -1007;
    public static final int MSG_TYPE_TEXT_SYSTEM_ADDREQUEST = -1006;
    public static final int MSG_TYPE_TEXT_SYSTEM_ADDSUCCESS = -1010;
    public static final int MSG_TYPE_TEXT_SYSTEM_OLD_VERSION_ADDREQUEST = -1011;
    public static final int MSG_TYPE_TEXT_SYSTEM_REFUSE = -1009;
    public static final int MSG_TYPE_TEXT_VIDEO = -1001;
    public static final int MSG_TYPE_TIM_AIOMSG_TIPS = -3016;
    public static final int MSG_TYPE_TIM_DOUFU_GUIDE = -3015;
    public static final int MSG_TYPE_TIM_GUIDE = -3014;
    public static final int MSG_TYPE_TRIBE_SHORT_VIDEO = -7002;
    public static final int MSG_TYPE_TROOP_CONFESS = -2067;
    public static final int MSG_TYPE_TROOP_DELIVER_GIFT = -2035;
    public static final int MSG_TYPE_TROOP_DELIVER_GIFT_OBJ = -2038;
    public static final int MSG_TYPE_TROOP_EFFECT_PIC = -5015;
    public static final int MSG_TYPE_TROOP_FEE = -2036;
    public static final int MSG_TYPE_TROOP_GAP_GRAY_TIPS = -2030;
    public static final int MSG_TYPE_TROOP_MIXED = -30003;
    public static final int MSG_TYPE_TROOP_NEWER_POBING = -2059;
    public static final int MSG_TYPE_TROOP_OBJ_MSG = -2017;
    public static final int MSG_TYPE_TROOP_REWARD = -2048;
    public static final int MSG_TYPE_TROOP_SIGN = -2054;
    public static final int MSG_TYPE_TROOP_STAR_LEAGUE = -2069;
    public static final int MSG_TYPE_TROOP_STORY = -2057;
    public static final int MSG_TYPE_TROOP_TIPS_ADD_MEMBER = -1012;
    public static final int MSG_TYPE_TROOP_UNREAD_TIPS = -4009;
    public static final int MSG_TYPE_TROOP_WANT_GIFT_MSG = -2056;
    public static final int MSG_TYPE_UNCOMMONLY_USED_CONTACTS = -1026;
    public static final int MSG_TYPE_UNCOMMONLY_USED_CONTACTS_CANCEL_SET = -1027;
    public static final int MSG_TYPE_UNITE_GRAY_HISTORY_INVI = -5021;
    public static final int MSG_TYPE_UNITE_GRAY_NORMAL = -5040;
    public static final int MSG_TYPE_UNITE_GRAY_TAB_INVI = -5020;
    public static final int MSG_TYPE_UNITE_TAB_DB_INVI = -5022;
    public static final int MSG_TYPE_UNITE_TAB_HISTORI_INVI = -5023;
    public static final int MSG_TYPE_VAS_APOLLO = -2039;
    public static final int MSG_TYPE_VIDEO_EMOTICON = -2079;
    public static final int MSG_TYPE_VIP_AIO_SEND_TIPS = -4022;
    public static final int MSG_TYPE_VIP_DONATE = -2047;
    public static final int MSG_TYPE_VIP_KEYWORD = -4021;
    public static final int MSG_TYPE_VIP_VIDEO = -2045;
    public static final int MSG_TYPE_YANZHI = -2070;
    public static final int MSG_TYPE_ZPLAN = -2078;
    public static final int MSG_VERSION_CODE = 3;
    public static final int MSG_VERSION_CODE_FOR_PICPTT = 3;
    public static final String QUERY_NEW_TABLE_FIELDS = "_id, extraflag, frienduin, isread, issend, istroop, NULL as msg, msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, versionCode, longMsgIndex, longMsgId, longMsgCount, isValid, msgUid, vipBubbleID, uniseq, sendFailCode, extStr, extInt, extLong ";
    public static final String QUERY_OLD_TABLE_FIELDS = "_id, extraflag, frienduin, isread, issend, istroop, msg, NULL as msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, 0 as versionCode, NULL as longMsgIndex, NULL as longMsgId, NULL as longMsgCount, 1 as isValid, NULL as msgUid, NULL as vipBubbleID, 0 as uniseq, 0 as sendFailCode, NULL as extStr, 0 as extInt, 0 as extLong";
    public static final int SEND_FAIL_CODE_DEFAULT = 0;
    public static final int SEND_FAIL_CODE_GOLDMSG_ERROR = -900;

    public ArrayList<AtTroopMemberInfo> atInfoTempList;
    public int extInt;
    public int extLong;
    public Object extObj;
    public String extStr;
    public int extraflag;
    public String frienduin;
    public boolean isread;
    public int issend;
    public int istroop;
    public int longMsgCount;
    public int longMsgId;
    public int longMsgIndex;
    public JSONObject mExJsonObject;
    public int mIsShowQidianTips;
    //public e mMessageInfo;
    public long mQidianMasterUin;
    public int mQidianTaskId;
    public String mQidianTipText;
    public int mRobotFlag;

    public String f167639msg;
    public String msg2;
    public long msgBackupMsgRandom;
    public long msgBackupMsgSeq;
    public byte[] msgData;
    public long msgUid;
    public long msgseq;
    public int msgtype;
    public String selfuin;
    public int sendFailCode;
    public String senderuin;
    public long shmsgseq;
    public Object stickerInfo;
    public String telemetryTracerKey;
    public long time;
    public long uniseq;
    public int vipBubbleDiyTextId;
    public long vipBubbleID;
    public int vipSubBubbleId;

    public boolean isReplySource = false;
    public boolean isMultiMsg = false;
    public boolean isBlessMsg = false;
    public boolean needUpdateMsgTag = true;
    public boolean isCheckNeedShowInListTypeMsg = false;
    public boolean needNeedShowInList = false;
    public boolean isReMultiMsg = false;
    public boolean isValid = true;
    public int versionCode = 3;
    public Object advertisementItem = null;
    public boolean isOpenTroopMessage = false;
    public boolean stickerHidden = false;
    public boolean isFolded = true;
    public boolean updateMsgAnimation = false;
    public boolean isGlassReaded = false;
    public boolean fromRegisterProxy = false;

    public boolean isLongMsg() {
        return this.longMsgCount > 1;
    }

    public int getPttStreamFlag() {
        return (short) (this.extInt & 65535);
    }

    public int getRepeatCount() {
        return (short) (this.extInt >> 16);
    }

    public long getTime() {
        return this.time;
    }

    public boolean isSend() {
        return false;
    }

    public void setPttStreamFlag(int i2) {
    }

    public void setRepeatCount(int i2) {
    }

    public void setSelfIsConfessor(boolean z) {
    }


}
