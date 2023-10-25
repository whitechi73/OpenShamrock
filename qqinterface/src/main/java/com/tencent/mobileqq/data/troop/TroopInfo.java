package com.tencent.mobileqq.data.troop;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class TroopInfo {
    public static final int ALLOW_HISTORY_MSG_READ_FOR_NEW_MEMBER = 4;
    public static final int ALLOW_UPLOAD_TROOP_ALBUM = 1;
    public static final int ALLOW_UPLOAD_TROOP_FILE = 2;
    public static final int CMDUIN_FLAG_EX3_SHOW_GAME_CARD = 1;
    public static final int CMDUIN_FLAG_EX3_SHOW_GAME_SKIN = 2;
    public static final int CONFESS_TALK_OPEN_FLAG = 8192;
    public static final int DEL_PIC_REQ = 2;
    public static final int GROUP_CLASS_EXT_TYPE_CLASSMATES = 10011;
    public static final int GROUP_CLASS_EXT_TYPE_FANS = 27;
    public static final int GROUP_CLASS_EXT_TYPE_GAME = 25;
    public static final int GROUP_CLASS_EXT_TYPE_HOMEWORK = 32;
    public static final int GROUP_CLASS_EXT_TYPE_IGNORE = 0;
    public static final int GROUP_CLASS_EXT_TYPE_OFFICIAL = 10012;
    public static final int GROUP_CLASS_EXT_TYPE_RELATIVES = 10010;
    public static final int GROUP_CLASS_EXT_TYPE_WORKMATES = 10009;
    public static final int G_FLAG_EX4_HAS_SCHOOL_GROUP_INFO = 128;
    public static final int G_FLAG_EX4_TROOP_GAME_CARD_ENABLED = 4096;
    public static final int G_FLAG_EX4_TROOP_IS_LIVE = 1024;
    public static final int KING_TEAM_APPID = 1104466820;
    public static final int KING_TEAM_TROOP_SUBTYPE_BATTLE = 0;
    @Deprecated
    public static final int MODIFY_ORDER = 0;
    public static final int ONLY_TROOP_MEMBER_INVITE_JOIN_TROOP = 4;
    public static final int PAY_CHOICE_PAY_TO_JOIN_TROOP = 512;
    public static final int PAY_PRIVILEGE_ALL = 448;
    public static final int PAY_PRIVILEGE_DELIVER_GIFT = 32;
    public static final int PAY_PRIVILEGE_GIFT_SETTLEMENT_ABILITY = 256;
    public static final int PAY_PRIVILEGE_GROUP_FEE = 64;
    public static final int PAY_PRIVILEGE_PAY_TO_JOIN_TROOP = 128;
    public static final int QIDIAN_PRIVATE_TROOP_FLAG = 32;
    public static final int QZONE_TROOP_ENTRANCE = 131072;
    public static final int SET_DEFAULT_PIC = 1;
    public static final String TABLE_NAME = "TroopInfoV2";
    public static final String TAG = "TroopInfo";
    public static final int TROOP_AUTO_APPROVAL = 1048576;
    public static final int TROOP_AVGAME_IS_OPENING = 268435456;
    public static final int TROOP_AVGAME_ONLY_ALLOW_MANAGER_CREATE = 536870912;
    public static final int TROOP_GAME_BIND = 2048;
    public static final int TROOP_GUILD_SWITCH_CLOSE = 1;
    public static final int TROOP_GUILD_SWITCH_OPEN = 0;
    public static final int TROOP_HONOR_AIO_SWITCH = 33554432;
    public static final int TROOP_LISTEN_TOGETHER = 2097152;
    public static final long TROOP_NAME_TIME_LIMIT = 86400000;
    public static final int TROOP_PRIVILEGE_INVITE_NEED_REVIEW = 101711872;
    public static final int TROOP_PRIVILEGE_INVITE_WITHOUT_REVIEW = 1048576;
    public static final int TROOP_PRIVILEGE_INVITE_WITHOUT_REVIEW_MEMCOUNT_IN_100 = 67108864;
    public static final int TROOP_PRIVILEGE_INVITE_WITHOUT_REVIEW_MEMCOUNT_IN_50 = 33554432;
    public static final int TROOP_SHARE_LOCATION = 67108864;
    public static final int TROOP_SING_TOGETHER = 16777216;
    public static final int TROOP_STUDY_ROOM_OPEN = 256;
    public static final int TROOP_WATCH_TOGETHER = 4194304;
    public static final int TROOP_WRITE_TOGETHER_SWITCH = 1073741824;
    public static final int TYPE_0X810_GROUP_RING_TONG_ID = 9;
    public static final int TYPE_0X810_GROUP_RING_TONG_SWITCH = 2048;
    public static final int TYPE_0X810_GROUP_VIBRATE_SWITCH = 4096;
    public static final int TYPE_0X810_MSG_HIDE_SWITCH = 512;
    public static final int TYPE_0X810_MSG_PREVIEW_SWITCH = 1024;

    public String Administrator;
    public String adminNameShow;
    public int allowMemberAtAll;
    public int allowMemberKick;
    public int allowMemberModifTroopName;
    public long associatePubAccount;
    public short cGroupLevel;
    public short cGroupOption;
    public String dailyNewMemberUins;
    public long discussMaxSeq;
    public long discussToTroopTime;
    public String discussUin;
    public long dwAdditionalFlag;
    public long dwCmdUinJoinTime;
    public long dwCmdUinUinFlag;
    public long dwGagTimeStamp;
    public long dwGagTimeStamp_me;
    public long dwGroupClassExt;
    public long dwGroupFlag;
    public long dwGroupLevelSeq;
    public long dwLastBAFTipMsgUniSeq;
    public long dwLastBAFTipMsgUniSeq2;
    public long dwLastInsertBAFTipTime;
    public String feeds_id;
    public String fingertroopmemo;
    public int grade;
    public String groupCardPrefixIntro;
    public String groupCardPrefixJson;
    public int groupFlagExt4;
    public int groupFreezeReason;
    public boolean hasSetNewTroopHead;
    public boolean hasSetNewTroopName;
    public long hlGuildAppid;
    public int hlGuildOrgid;
    public long hlGuildSubType;
    public boolean isNewTroop;
    public String joinTroopAnswer;
    public String joinTroopQuestion;
    public long lastMsgUpdateMyHonorRichTime;
    public String location;
    public String mAtOrReplyMeUins;
    ConcurrentHashMap<Integer, String> mCachedLevelMap;
    ConcurrentHashMap<Integer, String> mCachedNewLevelMap;
    public boolean mCanSearchByKeywords;
    public boolean mCanSearchByTroopUin;
    public int mComparePartInt;
    public String mCompareSpell;
    public String mGroupClassExtText;
    public String mHeaderUinsNew;
    public String mHeaderUinsOld;
    public int mIsFreezed;
    public boolean mMemberInvitingFlag;
    public String mRichFingerMemo;
    public String mSomeMemberUins;
    public String mTags;
    public int mTroopAvatarId;
    public int mTroopFileVideoIsWhite;
    public long mTroopFileVideoReqInterval;
    public int maxAdminNum;
    public int maxInviteMemNum;
    public String memberListToShow;
    public String myHonorList;
    public byte myHonorRichFlag;
    public int nTroopGrade;
    public String newTroopLevelMap;
    public String newTroopName;
    public long newTroopNameTimeStamp;
    public String oldTroopName;
    public String ownerNameShow;
    public String school;
    public String strLocation;
    public String strQZonePhotoUrls;
    public long timeSec;
    public String topicId;
    public String troopAuthenticateInfo;
    public long troopCreateTime;
    public int troopGuildSwitchOpen;
    public int troopHonorGrayFlag;
    public byte[] troopInfoExtByte;
    public String troopLevelMap;
    public String troopRemark;
    public String troopcode;
    public short troopface;
    public String troopmemo;
    public String troopname;
    public String troopowneruin;
    public int trooptype;
    public String troopuin;
    public long udwCmdUinRingtoneID;
    public String uin;
    public int wClickBAFTipCount;
    public int wInsertBAFTipCount;
    public int wMemberMax;
    public int wMemberNum;
    public int wMemberNumClient;
    public int wSpecialClass;
    public int troopmask = -1;
    public long dwGroupFlagExt = 0;
    public long dwAuthGroupType = 0;
    public long dwGroupInfoSeq = 0;
    public long mMemberNumSeq = -1;
    public long mOldMemberNumSeq = -1;
    public long mMemberCardSeq = -1;
    public long mOldMemberCardSeq = -1;
    public byte cGroupRankSysFlag = 0;
    public byte cGroupRankUserFlag = 0;
    public byte cNewGroupRankUserFlag = 0;
    public byte cAlbumResult = 0;
    public long dwTimeStamp = 0;
    public int mQZonePhotoNum = 0;
    public int troopLat = 0;
    public int troopLon = 0;
    public List<TroopClipPic> mTroopPicList = new ArrayList(8);
    public Set<String> mTroopVerifyingPics = new HashSet();
    public String mTroopPicListJson = "";
    public long troopPrivilegeFlag = 0;
    public float mTroopNeedPayNumber = 0.0f;
    public long troopCreditLevel = 5;
    public long troopCreditLevelInfo = 0;
    public boolean isTroopBlocked = false;
    public long appealDeadline = 0;
    public long dwAppPrivilegeFlag = 0;
    public int isShowInNearbyTroops = -1;
    public int troopTypeExt = -1;
    public long dwOfficeMode = 0;
    public long dwGroupFlagExt3 = 0;
    public long cmdUinFlagEx2 = 0;
    public long lastMsgTime = 0;
    public int exitTroopReason = 0;
    public int eliminated = 0;
    public String strLastAnnouncement = null;
    public int nMsgLimitFreq = 0;
    public int hlGuildBinary = 1;
    public int gameSwitchStatus = 0;
    public int showGameSwitchStatus = 0;
    public int isAllowHistoryMsgFlag = 0;
    public int troopRepeatType = 0;
    public long groupAllianceid = 0;
    public TroopInfoExt mTroopInfoExtObj = new TroopInfoExt();
    public long cmduinFlagEx3Grocery = 0;

    public boolean isAdmin() {
        return (this.dwAdditionalFlag & 1) == 1 || (this.dwCmdUinUinFlag & 1) == 1;
    }

    public boolean hasTroopAssociation() {
        return this.groupAllianceid != 0;
    }

    public boolean isAVGameOpen() {
        return (this.dwGroupFlagExt3 & 0x10000000) != 0;
    }

    public boolean isAllowCreateDiscuss() {
        return (this.troopPrivilegeFlag & 32768) == 0;
    }

    public boolean isAllowCreateTempConv() {
        return (this.troopPrivilegeFlag & 65536) == 0;
    }

    public boolean isAutoApprovalOpen() {
        return (this.dwGroupFlagExt3 & 1048576) == 1048576;
    }

    public boolean isDisband() {
        return this.exitTroopReason == 2;
    }

    public boolean isExited() {
        return this.exitTroopReason != 0;
    }

    public boolean isFansTroop() {
        return this.dwGroupClassExt == 27;
    }

    public boolean isGameBind() {
        return (this.dwGroupFlagExt3 & 2048) != 0;
    }

    public boolean isGameTroop() {
        return this.dwGroupClassExt == 25;
    }

    public boolean isHistoryMsgReadEnableForNewMember() {
        return this.isAllowHistoryMsgFlag == 1;
    }

    public boolean isHomeworkTroop() {
        return this.dwGroupClassExt == 32;
    }

    public boolean isKicked() {
        return this.exitTroopReason == 1;
    }
}