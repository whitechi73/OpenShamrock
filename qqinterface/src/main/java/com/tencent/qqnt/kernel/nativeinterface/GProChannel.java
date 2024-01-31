package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

public  final class GProChannel implements Serializable {
    long anchorTinyId;
    GProApplicationChannelInfo appChannelInfo;
    ArrayList<GProAuthControlStatus> authControlStatusList;
    GProAVChannelExtInfo avChannelExtInfo;
    int bannedSpeak;
    long channelId;
    int channelLiveableType;
    int channelVisibleType;
    long createTime;
    long creatorTinyId;
    int currentSlowModeKey;
    int finalNotifyType;
    int forumSortMode;
    long gotoChannelId;
    long guildId;
    String hotIcon;
    int isCategoryAdmin;
    int isChannelAdmin;
    int jumpSwitch;
    long lastCntMsgSeq;
    long lastCntMsgTime;
    long lastMsgSeq;
    long lastMsgTime;
    GProMedalInfo medalInfo;
    byte[] msgMeta;
    int msgNotifyType;
    int myForumSortMode;
    int mySpeakPermission;
    String name;
    long readCntMsgSeq;
    long readCntMsgTime;
    byte[] readMsgMeta;
    long readMsgSeq;
    long readMsgTime;
    int result;
    long roomId;
    String roomName;
    String schema;
    long serialVersionUID;
    ArrayList<GProSlowModeInfo> slowModeInfo;
    ArrayList<Integer> specialTypes;
    int switchMapMode;
    int talkPermission;
    int textChannelSubtypeId;
    ArrayList<GProTopMsg> topMsgList;
    long topMsgOperatorTinyId;
    long topMsgSeq;
    long topMsgTime;
    int type;
    int uint32HotIndex;
    int visibleType;
    ArrayList<GProVisibleTypeInfo> visibleTypeInfo;
    GProWorldSlowModeConfig xWorldslowModeConfig;

    public GProChannel() {
        this.serialVersionUID = 1L;
        this.name = "";
        this.msgMeta = new byte[0];
        this.readMsgMeta = new byte[0];
        this.roomName = "";
        this.specialTypes = new ArrayList<>();
        this.slowModeInfo = new ArrayList<>();
        this.visibleTypeInfo = new ArrayList<>();
        this.topMsgList = new ArrayList<>();
        this.appChannelInfo = new GProApplicationChannelInfo();
        this.authControlStatusList = new ArrayList<>();
        this.schema = "";
        this.xWorldslowModeConfig = new GProWorldSlowModeConfig();
        this.avChannelExtInfo = new GProAVChannelExtInfo();
        this.hotIcon = "";
        this.medalInfo = new GProMedalInfo();
    }

    public long getAnchorTinyId() {
        return this.anchorTinyId;
    }

    public GProApplicationChannelInfo getAppChannelInfo() {
        return this.appChannelInfo;
    }

    public ArrayList<GProAuthControlStatus> getAuthControlStatusList() {
        return this.authControlStatusList;
    }

    public GProAVChannelExtInfo getAvChannelExtInfo() {
        return this.avChannelExtInfo;
    }

    public int getBannedSpeak() {
        return this.bannedSpeak;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public int getChannelLiveableType() {
        return this.channelLiveableType;
    }

    public int getChannelVisibleType() {
        return this.channelVisibleType;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public long getCreatorTinyId() {
        return this.creatorTinyId;
    }

    public int getCurrentSlowModeKey() {
        return this.currentSlowModeKey;
    }

    public int getFinalNotifyType() {
        return this.finalNotifyType;
    }

    public int getForumSortMode() {
        return this.forumSortMode;
    }

    public long getGotoChannelId() {
        return this.gotoChannelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getHotIcon() {
        return this.hotIcon;
    }

    public int getIsCategoryAdmin() {
        return this.isCategoryAdmin;
    }

    public int getIsChannelAdmin() {
        return this.isChannelAdmin;
    }

    public int getJumpSwitch() {
        return this.jumpSwitch;
    }

    public long getLastCntMsgSeq() {
        return this.lastCntMsgSeq;
    }

    public long getLastCntMsgTime() {
        return this.lastCntMsgTime;
    }

    public long getLastMsgSeq() {
        return this.lastMsgSeq;
    }

    public long getLastMsgTime() {
        return this.lastMsgTime;
    }

    public GProMedalInfo getMedalInfo() {
        return this.medalInfo;
    }

    public byte[] getMsgMeta() {
        return this.msgMeta;
    }

    public int getMsgNotifyType() {
        return this.msgNotifyType;
    }

    public int getMyForumSortMode() {
        return this.myForumSortMode;
    }

    public int getMySpeakPermission() {
        return this.mySpeakPermission;
    }

    public String getName() {
        return this.name;
    }

    public long getReadCntMsgSeq() {
        return this.readCntMsgSeq;
    }

    public long getReadCntMsgTime() {
        return this.readCntMsgTime;
    }

    public byte[] getReadMsgMeta() {
        return this.readMsgMeta;
    }

    public long getReadMsgSeq() {
        return this.readMsgSeq;
    }

    public long getReadMsgTime() {
        return this.readMsgTime;
    }

    public int getResult() {
        return this.result;
    }

    public long getRoomId() {
        return this.roomId;
    }

    public String getRoomName() {
        return this.roomName;
    }

    public String getSchema() {
        return this.schema;
    }

    public ArrayList<GProSlowModeInfo> getSlowModeInfo() {
        return this.slowModeInfo;
    }

    public ArrayList<Integer> getSpecialTypes() {
        return this.specialTypes;
    }

    public int getSwitchMapMode() {
        return this.switchMapMode;
    }

    public int getTalkPermission() {
        return this.talkPermission;
    }

    public int getTextChannelSubtypeId() {
        return this.textChannelSubtypeId;
    }

    public ArrayList<GProTopMsg> getTopMsgList() {
        return this.topMsgList;
    }

    public long getTopMsgOperatorTinyId() {
        return this.topMsgOperatorTinyId;
    }

    public long getTopMsgSeq() {
        return this.topMsgSeq;
    }

    public long getTopMsgTime() {
        return this.topMsgTime;
    }

    public int getType() {
        return this.type;
    }

    public int getUint32HotIndex() {
        return this.uint32HotIndex;
    }

    public int getVisibleType() {
        return this.visibleType;
    }

    public ArrayList<GProVisibleTypeInfo> getVisibleTypeInfo() {
        return this.visibleTypeInfo;
    }

    public GProWorldSlowModeConfig getXWorldslowModeConfig() {
        return this.xWorldslowModeConfig;
    }

    public void setAnchorTinyId(long j2) {
        this.anchorTinyId = j2;
    }

    public void setAppChannelInfo(GProApplicationChannelInfo gProApplicationChannelInfo) {
        this.appChannelInfo = gProApplicationChannelInfo;
    }

    public void setAuthControlStatusList(ArrayList<GProAuthControlStatus> arrayList) {
        this.authControlStatusList = arrayList;
    }

    public void setAvChannelExtInfo(GProAVChannelExtInfo gProAVChannelExtInfo) {
        this.avChannelExtInfo = gProAVChannelExtInfo;
    }

    public void setBannedSpeak(int i2) {
        this.bannedSpeak = i2;
    }

    public void setChannelId(long j2) {
        this.channelId = j2;
    }

    public void setChannelLiveableType(int i2) {
        this.channelLiveableType = i2;
    }

    public void setChannelVisibleType(int i2) {
        this.channelVisibleType = i2;
    }

    public void setCreateTime(long j2) {
        this.createTime = j2;
    }

    public void setCreatorTinyId(long j2) {
        this.creatorTinyId = j2;
    }

    public void setCurrentSlowModeKey(int i2) {
        this.currentSlowModeKey = i2;
    }

    public void setFinalNotifyType(int i2) {
        this.finalNotifyType = i2;
    }

    public void setForumSortMode(int i2) {
        this.forumSortMode = i2;
    }

    public void setGotoChannelId(long j2) {
        this.gotoChannelId = j2;
    }

    public void setGuildId(long j2) {
        this.guildId = j2;
    }

    public void setHotIcon(String str) {
        this.hotIcon = str;
    }

    public void setIsCategoryAdmin(int i2) {
        this.isCategoryAdmin = i2;
    }

    public void setIsChannelAdmin(int i2) {
        this.isChannelAdmin = i2;
    }

    public void setJumpSwitch(int i2) {
        this.jumpSwitch = i2;
    }

    public void setLastCntMsgSeq(long j2) {
        this.lastCntMsgSeq = j2;
    }

    public void setLastCntMsgTime(long j2) {
        this.lastCntMsgTime = j2;
    }

    public void setLastMsgSeq(long j2) {
        this.lastMsgSeq = j2;
    }

    public void setLastMsgTime(long j2) {
        this.lastMsgTime = j2;
    }

    public void setMedalInfo(GProMedalInfo gProMedalInfo) {
        this.medalInfo = gProMedalInfo;
    }

    public void setMsgMeta(byte[] bArr) {
        this.msgMeta = bArr;
    }

    public void setMsgNotifyType(int i2) {
        this.msgNotifyType = i2;
    }

    public void setMyForumSortMode(int i2) {
        this.myForumSortMode = i2;
    }

    public void setMySpeakPermission(int i2) {
        this.mySpeakPermission = i2;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setReadCntMsgSeq(long j2) {
        this.readCntMsgSeq = j2;
    }

    public void setReadCntMsgTime(long j2) {
        this.readCntMsgTime = j2;
    }

    public void setReadMsgMeta(byte[] bArr) {
        this.readMsgMeta = bArr;
    }

    public void setReadMsgSeq(long j2) {
        this.readMsgSeq = j2;
    }

    public void setReadMsgTime(long j2) {
        this.readMsgTime = j2;
    }

    public void setResult(int i2) {
        this.result = i2;
    }

    public void setRoomId(long j2) {
        this.roomId = j2;
    }

    public void setRoomName(String str) {
        this.roomName = str;
    }

    public void setSchema(String str) {
        this.schema = str;
    }

    public void setSlowModeInfo(ArrayList<GProSlowModeInfo> arrayList) {
        this.slowModeInfo = arrayList;
    }

    public void setSpecialTypes(ArrayList<Integer> arrayList) {
        this.specialTypes = arrayList;
    }

    public void setSwitchMapMode(int i2) {
        this.switchMapMode = i2;
    }

    public void setTalkPermission(int i2) {
        this.talkPermission = i2;
    }

    public void setTextChannelSubtypeId(int i2) {
        this.textChannelSubtypeId = i2;
    }

    public void setTopMsgList(ArrayList<GProTopMsg> arrayList) {
        this.topMsgList = arrayList;
    }

    public void setTopMsgOperatorTinyId(long j2) {
        this.topMsgOperatorTinyId = j2;
    }

    public void setTopMsgSeq(long j2) {
        this.topMsgSeq = j2;
    }

    public void setTopMsgTime(long j2) {
        this.topMsgTime = j2;
    }

    public void setType(int i2) {
        this.type = i2;
    }

    public void setUint32HotIndex(int i2) {
        this.uint32HotIndex = i2;
    }

    public void setVisibleType(int i2) {
        this.visibleType = i2;
    }

    public void setVisibleTypeInfo(ArrayList<GProVisibleTypeInfo> arrayList) {
        this.visibleTypeInfo = arrayList;
    }

    public void setXWorldslowModeConfig(GProWorldSlowModeConfig gProWorldSlowModeConfig) {
        this.xWorldslowModeConfig = gProWorldSlowModeConfig;
    }

    public String toString() {
        return "GProChannel{channelId=" + this.channelId + ",guildId=" + this.guildId + ",name=" + this.name + ",type=" + this.type + ",creatorTinyId=" + this.creatorTinyId + ",createTime=" + this.createTime + ",talkPermission=" + this.talkPermission + ",msgNotifyType=" + this.msgNotifyType + ",lastMsgSeq=" + this.lastMsgSeq + ",lastCntMsgSeq=" + this.lastCntMsgSeq + ",readMsgSeq=" + this.readMsgSeq + ",readCntMsgSeq=" + this.readCntMsgSeq + ",lastMsgTime=" + this.lastMsgTime + ",lastCntMsgTime=" + this.lastCntMsgTime + ",readMsgTime=" + this.readMsgTime + ",readCntMsgTime=" + this.readCntMsgTime + ",msgMeta=" + this.msgMeta + ",readMsgMeta=" + this.readMsgMeta + ",result=" + this.result + ",roomId=" + this.roomId + ",anchorTinyId=" + this.anchorTinyId + ",roomName=" + this.roomName + ",bannedSpeak=" + this.bannedSpeak + ",visibleType=" + this.visibleType + ",specialTypes=" + this.specialTypes + ",finalNotifyType=" + this.finalNotifyType + ",topMsgSeq=" + this.topMsgSeq + ",topMsgTime=" + this.topMsgTime + ",topMsgOperatorTinyId=" + this.topMsgOperatorTinyId + ",currentSlowModeKey=" + this.currentSlowModeKey + ",slowModeInfo=" + this.slowModeInfo + ",forumSortMode=" + this.forumSortMode + ",myForumSortMode=" + this.myForumSortMode + ",textChannelSubtypeId=" + this.textChannelSubtypeId + ",channelVisibleType=" + this.channelVisibleType + ",visibleTypeInfo=" + this.visibleTypeInfo + ",mySpeakPermission=" + this.mySpeakPermission + ",isChannelAdmin=" + this.isChannelAdmin + ",topMsgList=" + this.topMsgList + ",appChannelInfo=" + this.appChannelInfo + ",channelLiveableType=" + this.channelLiveableType + ",authControlStatusList=" + this.authControlStatusList + ",schema=" + this.schema + ",xWorldslowModeConfig=" + this.xWorldslowModeConfig + ",switchMapMode=" + this.switchMapMode + ",avChannelExtInfo=" + this.avChannelExtInfo + ",gotoChannelId=" + this.gotoChannelId + ",jumpSwitch=" + this.jumpSwitch + ",uint32HotIndex=" + this.uint32HotIndex + ",hotIcon=" + this.hotIcon + ",medalInfo=" + this.medalInfo + ",isCategoryAdmin=" + this.isCategoryAdmin + ",}";
    }

    public GProChannel(long j2, long j3, String str, int i2, long j4, long j5, int i3, int i4, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, byte[] bArr, byte[] bArr2, int i5, long j14, long j15, String str2, int i6, int i7, ArrayList<Integer> arrayList, int i8, long j16, long j17, long j18, int i9, ArrayList<GProSlowModeInfo> arrayList2, int i10, int i11, int i12, int i13, ArrayList<GProVisibleTypeInfo> arrayList3, int i14, int i15, ArrayList<GProTopMsg> arrayList4, GProApplicationChannelInfo gProApplicationChannelInfo, int i16, ArrayList<GProAuthControlStatus> arrayList5, String str3, GProWorldSlowModeConfig gProWorldSlowModeConfig, int i17, GProAVChannelExtInfo gProAVChannelExtInfo, long j19, int i18, int i19, String str4, GProMedalInfo gProMedalInfo, int i20) {
        this.serialVersionUID = 1L;
        this.name = "";
        this.msgMeta = new byte[0];
        this.readMsgMeta = new byte[0];
        this.roomName = "";
        this.specialTypes = new ArrayList<>();
        this.slowModeInfo = new ArrayList<>();
        this.visibleTypeInfo = new ArrayList<>();
        this.topMsgList = new ArrayList<>();
        this.appChannelInfo = new GProApplicationChannelInfo();
        this.authControlStatusList = new ArrayList<>();
        this.schema = "";
        this.xWorldslowModeConfig = new GProWorldSlowModeConfig();
        this.avChannelExtInfo = new GProAVChannelExtInfo();
        this.hotIcon = "";
        this.medalInfo = new GProMedalInfo();
        this.channelId = j2;
        this.guildId = j3;
        this.name = str;
        this.type = i2;
        this.creatorTinyId = j4;
        this.createTime = j5;
        this.talkPermission = i3;
        this.msgNotifyType = i4;
        this.lastMsgSeq = j6;
        this.lastCntMsgSeq = j7;
        this.readMsgSeq = j8;
        this.readCntMsgSeq = j9;
        this.lastMsgTime = j10;
        this.lastCntMsgTime = j11;
        this.readMsgTime = j12;
        this.readCntMsgTime = j13;
        this.msgMeta = bArr;
        this.readMsgMeta = bArr2;
        this.result = i5;
        this.roomId = j14;
        this.anchorTinyId = j15;
        this.roomName = str2;
        this.bannedSpeak = i6;
        this.visibleType = i7;
        this.specialTypes = arrayList;
        this.finalNotifyType = i8;
        this.topMsgSeq = j16;
        this.topMsgTime = j17;
        this.topMsgOperatorTinyId = j18;
        this.currentSlowModeKey = i9;
        this.slowModeInfo = arrayList2;
        this.forumSortMode = i10;
        this.myForumSortMode = i11;
        this.textChannelSubtypeId = i12;
        this.channelVisibleType = i13;
        this.visibleTypeInfo = arrayList3;
        this.mySpeakPermission = i14;
        this.isChannelAdmin = i15;
        this.topMsgList = arrayList4;
        this.appChannelInfo = gProApplicationChannelInfo;
        this.channelLiveableType = i16;
        this.authControlStatusList = arrayList5;
        this.schema = str3;
        this.xWorldslowModeConfig = gProWorldSlowModeConfig;
        this.switchMapMode = i17;
        this.avChannelExtInfo = gProAVChannelExtInfo;
        this.gotoChannelId = j19;
        this.jumpSwitch = i18;
        this.uint32HotIndex = i19;
        this.hotIcon = str4;
        this.medalInfo = gProMedalInfo;
        this.isCategoryAdmin = i20;
    }
}
