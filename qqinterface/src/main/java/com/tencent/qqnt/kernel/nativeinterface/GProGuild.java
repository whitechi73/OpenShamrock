package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProGuild implements Serializable {
    int QRCodePeriod;
    ArrayList<Long> adminList;
    int adminMaxNum;
    boolean allowSearch;
    long avatarSeq;
    long bannedTimeLimit;
    long changeNameInterval;
    boolean channelListChange;
    int clientId;
    int coverFontColorId;
    long coverSeq;
    long createTime;
    long creatorTinyId;
    String errMsg;
    long groupId;
    int guildCanShare;
    long guildId;
    long guildNameChangeTime;
    String guildNumber;
    int guildType;
    boolean isBanned;
    boolean isFrozen;
    boolean isInteractiveForVisitor;
    boolean isInvisibleForVisitor;
    int isMember;
    int isOpenMsgPush;
    boolean isTop;
    boolean isValid;
    long joinTime;
    long jumpChannelId;
    boolean jumpChannelSwitch;
    ArrayList<GProMedalInfo> medalInfoList;
    int medalLevel;
    long myShutUpExpireTime;
    String name;
    ArrayList<GProNavigationInfo> navigationInfoList;
    boolean needRealNameForVisitor;
    String profile;
    int qrCodeSwitch;
    int result;
    ArrayList<Long> robotList;
    int robotMaxNum;
    String searchJoinSig;
    long serialVersionUID;
    long showNumber;
    boolean showWeakNotify;
    long shutUpExpireTime;
    GProGuildSpeakableThreshold speakThreshold;
    String tagDesc;
    long tagId;
    boolean topicSquareSwitch;
    long u64channelSeq;
    long u64guildSeq;
    int userMaxNum;
    int userNum;
    int userType;
    int visibleChannelMaxNum;
    int weakNotifyDisplay;

    public GProGuild() {
        this.serialVersionUID = 1L;
        this.name = "";
        this.profile = "";
        this.adminList = new ArrayList<>();
        this.robotList = new ArrayList<>();
        this.searchJoinSig = "";
        this.errMsg = "";
        this.guildNumber = "";
        this.navigationInfoList = new ArrayList<>();
        this.speakThreshold = new GProGuildSpeakableThreshold();
        this.medalInfoList = new ArrayList<>();
        this.tagDesc = "";
    }

    public ArrayList<Long> getAdminList() {
        return this.adminList;
    }

    public int getAdminMaxNum() {
        return this.adminMaxNum;
    }

    public boolean getAllowSearch() {
        return this.allowSearch;
    }

    public long getAvatarSeq() {
        return this.avatarSeq;
    }

    public long getBannedTimeLimit() {
        return this.bannedTimeLimit;
    }

    public long getChangeNameInterval() {
        return this.changeNameInterval;
    }

    public boolean getChannelListChange() {
        return this.channelListChange;
    }

    public int getClientId() {
        return this.clientId;
    }

    public int getCoverFontColorId() {
        return this.coverFontColorId;
    }

    public long getCoverSeq() {
        return this.coverSeq;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public long getCreatorTinyId() {
        return this.creatorTinyId;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public long getGroupId() {
        return this.groupId;
    }

    public int getGuildCanShare() {
        return this.guildCanShare;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public long getGuildNameChangeTime() {
        return this.guildNameChangeTime;
    }

    public String getGuildNumber() {
        return this.guildNumber;
    }

    public int getGuildType() {
        return this.guildType;
    }

    public boolean getIsBanned() {
        return this.isBanned;
    }

    public boolean getIsFrozen() {
        return this.isFrozen;
    }

    public boolean getIsInteractiveForVisitor() {
        return this.isInteractiveForVisitor;
    }

    public boolean getIsInvisibleForVisitor() {
        return this.isInvisibleForVisitor;
    }

    public int getIsMember() {
        return this.isMember;
    }

    public int getIsOpenMsgPush() {
        return this.isOpenMsgPush;
    }

    public boolean getIsTop() {
        return this.isTop;
    }

    public boolean getIsValid() {
        return this.isValid;
    }

    public long getJoinTime() {
        return this.joinTime;
    }

    public long getJumpChannelId() {
        return this.jumpChannelId;
    }

    public boolean getJumpChannelSwitch() {
        return this.jumpChannelSwitch;
    }

    public ArrayList<GProMedalInfo> getMedalInfoList() {
        return this.medalInfoList;
    }

    public int getMedalLevel() {
        return this.medalLevel;
    }

    public long getMyShutUpExpireTime() {
        return this.myShutUpExpireTime;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<GProNavigationInfo> getNavigationInfoList() {
        return this.navigationInfoList;
    }

    public boolean getNeedRealNameForVisitor() {
        return this.needRealNameForVisitor;
    }

    public String getProfile() {
        return this.profile;
    }

    public int getQRCodePeriod() {
        return this.QRCodePeriod;
    }

    public int getQrCodeSwitch() {
        return this.qrCodeSwitch;
    }

    public int getResult() {
        return this.result;
    }

    public ArrayList<Long> getRobotList() {
        return this.robotList;
    }

    public int getRobotMaxNum() {
        return this.robotMaxNum;
    }

    public String getSearchJoinSig() {
        return this.searchJoinSig;
    }

    public long getShowNumber() {
        return this.showNumber;
    }

    public boolean getShowWeakNotify() {
        return this.showWeakNotify;
    }

    public long getShutUpExpireTime() {
        return this.shutUpExpireTime;
    }

    public GProGuildSpeakableThreshold getSpeakThreshold() {
        return this.speakThreshold;
    }

    public String getTagDesc() {
        return this.tagDesc;
    }

    public long getTagId() {
        return this.tagId;
    }

    public boolean getTopicSquareSwitch() {
        return this.topicSquareSwitch;
    }

    public long getU64channelSeq() {
        return this.u64channelSeq;
    }

    public long getU64guildSeq() {
        return this.u64guildSeq;
    }

    public int getUserMaxNum() {
        return this.userMaxNum;
    }

    public int getUserNum() {
        return this.userNum;
    }

    public int getUserType() {
        return this.userType;
    }

    public int getVisibleChannelMaxNum() {
        return this.visibleChannelMaxNum;
    }

    public int getWeakNotifyDisplay() {
        return this.weakNotifyDisplay;
    }

    public void setAdminList(ArrayList<Long> arrayList) {
        this.adminList = arrayList;
    }

    public void setAdminMaxNum(int i2) {
        this.adminMaxNum = i2;
    }

    public void setAllowSearch(boolean z) {
        this.allowSearch = z;
    }

    public void setAvatarSeq(long j2) {
        this.avatarSeq = j2;
    }

    public void setBannedTimeLimit(long j2) {
        this.bannedTimeLimit = j2;
    }

    public void setChangeNameInterval(long j2) {
        this.changeNameInterval = j2;
    }

    public void setChannelListChange(boolean z) {
        this.channelListChange = z;
    }

    public void setClientId(int i2) {
        this.clientId = i2;
    }

    public void setCoverFontColorId(int i2) {
        this.coverFontColorId = i2;
    }

    public void setCoverSeq(long j2) {
        this.coverSeq = j2;
    }

    public void setCreateTime(long j2) {
        this.createTime = j2;
    }

    public void setCreatorTinyId(long j2) {
        this.creatorTinyId = j2;
    }

    public void setErrMsg(String str) {
        this.errMsg = str;
    }

    public void setGroupId(long j2) {
        this.groupId = j2;
    }

    public void setGuildCanShare(int i2) {
        this.guildCanShare = i2;
    }

    public void setGuildId(long j2) {
        this.guildId = j2;
    }

    public void setGuildNameChangeTime(long j2) {
        this.guildNameChangeTime = j2;
    }

    public void setGuildNumber(String str) {
        this.guildNumber = str;
    }

    public void setGuildType(int i2) {
        this.guildType = i2;
    }

    public void setIsBanned(boolean z) {
        this.isBanned = z;
    }

    public void setIsFrozen(boolean z) {
        this.isFrozen = z;
    }

    public void setIsInteractiveForVisitor(boolean z) {
        this.isInteractiveForVisitor = z;
    }

    public void setIsInvisibleForVisitor(boolean z) {
        this.isInvisibleForVisitor = z;
    }

    public void setIsMember(int i2) {
        this.isMember = i2;
    }

    public void setIsOpenMsgPush(int i2) {
        this.isOpenMsgPush = i2;
    }

    public void setIsTop(boolean z) {
        this.isTop = z;
    }

    public void setIsValid(boolean z) {
        this.isValid = z;
    }

    public void setJoinTime(long j2) {
        this.joinTime = j2;
    }

    public void setJumpChannelId(long j2) {
        this.jumpChannelId = j2;
    }

    public void setJumpChannelSwitch(boolean z) {
        this.jumpChannelSwitch = z;
    }

    public void setMedalInfoList(ArrayList<GProMedalInfo> arrayList) {
        this.medalInfoList = arrayList;
    }

    public void setMedalLevel(int i2) {
        this.medalLevel = i2;
    }

    public void setMyShutUpExpireTime(long j2) {
        this.myShutUpExpireTime = j2;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNavigationInfoList(ArrayList<GProNavigationInfo> arrayList) {
        this.navigationInfoList = arrayList;
    }

    public void setNeedRealNameForVisitor(boolean z) {
        this.needRealNameForVisitor = z;
    }

    public void setProfile(String str) {
        this.profile = str;
    }

    public void setQRCodePeriod(int i2) {
        this.QRCodePeriod = i2;
    }

    public void setQrCodeSwitch(int i2) {
        this.qrCodeSwitch = i2;
    }

    public void setResult(int i2) {
        this.result = i2;
    }

    public void setRobotList(ArrayList<Long> arrayList) {
        this.robotList = arrayList;
    }

    public void setRobotMaxNum(int i2) {
        this.robotMaxNum = i2;
    }

    public void setSearchJoinSig(String str) {
        this.searchJoinSig = str;
    }

    public void setShowNumber(long j2) {
        this.showNumber = j2;
    }

    public void setShowWeakNotify(boolean z) {
        this.showWeakNotify = z;
    }

    public void setShutUpExpireTime(long j2) {
        this.shutUpExpireTime = j2;
    }

    public void setSpeakThreshold(GProGuildSpeakableThreshold gProGuildSpeakableThreshold) {
        this.speakThreshold = gProGuildSpeakableThreshold;
    }

    public void setTagDesc(String str) {
        this.tagDesc = str;
    }

    public void setTagId(long j2) {
        this.tagId = j2;
    }

    public void setTopicSquareSwitch(boolean z) {
        this.topicSquareSwitch = z;
    }

    public void setU64channelSeq(long j2) {
        this.u64channelSeq = j2;
    }

    public void setU64guildSeq(long j2) {
        this.u64guildSeq = j2;
    }

    public void setUserMaxNum(int i2) {
        this.userMaxNum = i2;
    }

    public void setUserNum(int i2) {
        this.userNum = i2;
    }

    public void setUserType(int i2) {
        this.userType = i2;
    }

    public void setVisibleChannelMaxNum(int i2) {
        this.visibleChannelMaxNum = i2;
    }

    public void setWeakNotifyDisplay(int i2) {
        this.weakNotifyDisplay = i2;
    }

    public String toString() {
        return "GProGuild{guildId=" + this.guildId + ",showNumber=" + this.showNumber + ",guildType=" + this.guildType + ",name=" + this.name + ",profile=" + this.profile + ",avatarSeq=" + this.avatarSeq + ",creatorTinyId=" + this.creatorTinyId + ",createTime=" + this.createTime + ",joinTime=" + this.joinTime + ",userType=" + this.userType + ",isTop=" + this.isTop + ",userNum=" + this.userNum + ",u64guildSeq=" + this.u64guildSeq + ",u64channelSeq=" + this.u64channelSeq + ",adminList=" + this.adminList + ",adminMaxNum=" + this.adminMaxNum + ",robotList=" + this.robotList + ",robotMaxNum=" + this.robotMaxNum + ",userMaxNum=" + this.userMaxNum + ",isBanned=" + this.isBanned + ",isFrozen=" + this.isFrozen + ",isValid=" + this.isValid + ",searchJoinSig=" + this.searchJoinSig + ",channelListChange=" + this.channelListChange + ",coverSeq=" + this.coverSeq + ",isMember=" + this.isMember + ",result=" + this.result + ",errMsg=" + this.errMsg + ",clientId=" + this.clientId + ",visibleChannelMaxNum=" + this.visibleChannelMaxNum + ",medalLevel=" + this.medalLevel + ",weakNotifyDisplay=" + this.weakNotifyDisplay + ",isOpenMsgPush=" + this.isOpenMsgPush + ",shutUpExpireTime=" + this.shutUpExpireTime + ",myShutUpExpireTime=" + this.myShutUpExpireTime + ",bannedTimeLimit=" + this.bannedTimeLimit + ",coverFontColorId=" + this.coverFontColorId + ",guildCanShare=" + this.guildCanShare + ",QRCodePeriod=" + this.QRCodePeriod + ",guildNumber=" + this.guildNumber + ",guildNameChangeTime=" + this.guildNameChangeTime + ",allowSearch=" + this.allowSearch + ",isInvisibleForVisitor=" + this.isInvisibleForVisitor + ",needRealNameForVisitor=" + this.needRealNameForVisitor + ",isInteractiveForVisitor=" + this.isInteractiveForVisitor + ",changeNameInterval=" + this.changeNameInterval + ",showWeakNotify=" + this.showWeakNotify + ",jumpChannelSwitch=" + this.jumpChannelSwitch + ",jumpChannelId=" + this.jumpChannelId + ",navigationInfoList=" + this.navigationInfoList + ",speakThreshold=" + this.speakThreshold + ",medalInfoList=" + this.medalInfoList + ",topicSquareSwitch=" + this.topicSquareSwitch + ",groupId=" + this.groupId + ",tagId=" + this.tagId + ",tagDesc=" + this.tagDesc + ",qrCodeSwitch=" + this.qrCodeSwitch + ",}";
    }

    public GProGuild(long j2, long j3, int i2, String str, String str2, long j4, long j5, long j6, long j7, int i3, boolean z, int i4, long j8, long j9, ArrayList<Long> arrayList, int i5, ArrayList<Long> arrayList2, int i6, int i7, boolean z2, boolean z3, boolean z4, String str3, boolean z5, long j10, int i8, int i9, String str4, int i10, int i11, int i12, int i13, int i14, long j11, long j12, long j13, int i15, int i16, int i17, String str5, long j14, boolean z6, boolean z7, boolean z8, boolean z9, long j15, boolean z10, boolean z11, long j16, ArrayList<GProNavigationInfo> arrayList3, GProGuildSpeakableThreshold gProGuildSpeakableThreshold, ArrayList<GProMedalInfo> arrayList4, boolean z12, long j17, long j18, String str6, int i18) {
        this.serialVersionUID = 1L;
        this.name = "";
        this.profile = "";
        this.adminList = new ArrayList<>();
        this.robotList = new ArrayList<>();
        this.searchJoinSig = "";
        this.errMsg = "";
        this.guildNumber = "";
        this.navigationInfoList = new ArrayList<>();
        this.speakThreshold = new GProGuildSpeakableThreshold();
        this.medalInfoList = new ArrayList<>();
        this.tagDesc = "";
        this.guildId = j2;
        this.showNumber = j3;
        this.guildType = i2;
        this.name = str;
        this.profile = str2;
        this.avatarSeq = j4;
        this.creatorTinyId = j5;
        this.createTime = j6;
        this.joinTime = j7;
        this.userType = i3;
        this.isTop = z;
        this.userNum = i4;
        this.u64guildSeq = j8;
        this.u64channelSeq = j9;
        this.adminList = arrayList;
        this.adminMaxNum = i5;
        this.robotList = arrayList2;
        this.robotMaxNum = i6;
        this.userMaxNum = i7;
        this.isBanned = z2;
        this.isFrozen = z3;
        this.isValid = z4;
        this.searchJoinSig = str3;
        this.channelListChange = z5;
        this.coverSeq = j10;
        this.isMember = i8;
        this.result = i9;
        this.errMsg = str4;
        this.clientId = i10;
        this.visibleChannelMaxNum = i11;
        this.medalLevel = i12;
        this.weakNotifyDisplay = i13;
        this.isOpenMsgPush = i14;
        this.shutUpExpireTime = j11;
        this.myShutUpExpireTime = j12;
        this.bannedTimeLimit = j13;
        this.coverFontColorId = i15;
        this.guildCanShare = i16;
        this.QRCodePeriod = i17;
        this.guildNumber = str5;
        this.guildNameChangeTime = j14;
        this.allowSearch = z6;
        this.isInvisibleForVisitor = z7;
        this.needRealNameForVisitor = z8;
        this.isInteractiveForVisitor = z9;
        this.changeNameInterval = j15;
        this.showWeakNotify = z10;
        this.jumpChannelSwitch = z11;
        this.jumpChannelId = j16;
        this.navigationInfoList = arrayList3;
        this.speakThreshold = gProGuildSpeakableThreshold;
        this.medalInfoList = arrayList4;
        this.topicSquareSwitch = z12;
        this.groupId = j17;
        this.tagId = j18;
        this.tagDesc = str6;
        this.qrCodeSwitch = i18;
    }
}
