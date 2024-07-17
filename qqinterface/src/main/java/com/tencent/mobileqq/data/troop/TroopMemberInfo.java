package com.tencent.mobileqq.data.troop;

import org.jetbrains.annotations.Nullable;
import com.tencent.qqnt.kernelpublic.nativeinterface.MemberRole;

public class TroopMemberInfo {
    public static final long VALUE_DISTANCE_TO_SELF_UNKOWN = -100;
    protected static final int VALUE_INVALID = -100;
    public static final long VALUE_MEMBER_CLOSE_SHARE_LBS = -1001;

    public int addState;

    @Deprecated(since = "推荐使用TroopMemberNickInfo")
    public String autoremark;
    public long credit_level;
    public String displayedNamePinyinFirst;

    @Nullable
    public TroopMemberInfoExt extInfo;

    @Deprecated(since = "推荐使用TroopMemberNickInfo")
    public String friendnick;
    public long gagTimeStamp;
    public String honorList;
    public boolean isTroopFollowed;
    public long join_time;
    public long last_active_time;
    public int level;
    public int mBigClubVipType;
    public byte mHonorRichFlag;
    public boolean mIsShielded;
    public int mVipType;
    public String memberUid;
    public String memberuin;
    public int newRealLevel;
    public TroopMemberNickInfo nickInfo;
    public int realLevel;
    public MemberRole role;

    @Nullable
    public TroopMemberSpecialTitleInfo specialTitleInfo;

    @Deprecated(since = "推荐使用TroopMemberNickInfo")
    public String troopColorNick;

    @Deprecated(since = "推荐使用TroopMemberNickInfo")
    public int troopColorNickId;

    @Deprecated(since = "推荐使用TroopMemberNickInfo")
    public String troopnick;
    public String troopuin;
    public int globalTroopLevel = VALUE_INVALID;
    public int flagEx = 0;

    // QQ OLD API DATA
    public long active_point;
    public byte age;
    public String alias;
    public long cmduinFlagEx3Grocery;
    public long datetime;
    public short faceid;
    public String hwCourse;
    public int hwIdentity;
    public String hwName;
    public int isShowQZone;
    public long lastMsgUpdateHonorRichTime;
    public int mBigClubTemplateId;
    public int mBigClubVipLevel;
    public int mGlamourLevel;
    public int mIsHideBigClub;
    public String mUniqueTitle;
    public int mVipLevel;
    public int mVipTemplateId;
    public String pyAll_autoremark;
    public String pyAll_friendnick;
    public String pyAll_troopnick;
    public String pyFirst_autoremark;
    public String pyFirst_friendnick;
    public String pyFirst_troopnick;
    public String recommendRemark;
    public byte sex;
    public byte status;
    public int tribeLevel;
    public int tribePoint;
    public String troopremark;
    public int qqVipInfo = 0;
    public int superQqInfo = 0;
    public int superVipInfo = 0;
    public int hotChatGlamourLevel = -100;
    public int distance = 0;
    public long msgseq = -100;
    public double distanceToSelf = -100.0d;
    public long distanceToSelfUpdateTimeStamp = 0;
    public int mUniqueTitleExpire = 0;
    public int commonFrdCnt = Integer.MIN_VALUE;
}