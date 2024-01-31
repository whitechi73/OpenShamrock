package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

public  final class GProUser implements Serializable {
    int allowScreenShare;
    String avatarMeta;
    String avatarPendant;
    GProBusinessInfo businessInfo;
    int chnRole;
    GProClientIdentity clientIdentity;
    GProClientPresence clientPresence;
    byte[] cookie;
    int gender;
    long guildId;
    boolean guildMute;
    boolean inBlack;
    long joinTime;
    int levelRoleId;
    String memberName;
    ArrayList<Integer> myRoles;
    String nickName;
    int onlineState;
    GProMedal personalMedal;
    int platform;
    int robotMuteStatus;
    int robotPunishmentStatus;
    String robotTestGuilds;
    int robotType;
    GProRoleManagementTag roleManagementTag;
    long serialVersionUID;
    long shutUpExpireTime;
    long tinyId;
    int type;
    GProVoiceInfo voiceInfo;

    public GProUser() {
        this.serialVersionUID = 1L;
        this.memberName = "";
        this.nickName = "";
        this.cookie = new byte[0];
        this.clientIdentity = new GProClientIdentity();
        this.clientPresence = new GProClientPresence();
        this.robotTestGuilds = "";
        this.avatarMeta = "";
        this.voiceInfo = new GProVoiceInfo();
        this.businessInfo = new GProBusinessInfo();
        this.myRoles = new ArrayList<>();
        this.avatarPendant = "";
        this.personalMedal = new GProMedal();
        this.roleManagementTag = new GProRoleManagementTag();
    }

    public int getAllowScreenShare() {
        return this.allowScreenShare;
    }

    public String getAvatarMeta() {
        return this.avatarMeta;
    }

    public String getAvatarPendant() {
        return this.avatarPendant;
    }

    public GProBusinessInfo getBusinessInfo() {
        return this.businessInfo;
    }

    public int getChnRole() {
        return this.chnRole;
    }

    public GProClientIdentity getClientIdentity() {
        return this.clientIdentity;
    }

    public GProClientPresence getClientPresence() {
        return this.clientPresence;
    }

    public byte[] getCookie() {
        return this.cookie;
    }

    public int getGender() {
        return this.gender;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public boolean getGuildMute() {
        return this.guildMute;
    }

    public boolean getInBlack() {
        return this.inBlack;
    }

    public long getJoinTime() {
        return this.joinTime;
    }

    public int getLevelRoleId() {
        return this.levelRoleId;
    }

    public String getMemberName() {
        return this.memberName;
    }

    public ArrayList<Integer> getMyRoles() {
        return this.myRoles;
    }

    public String getNickName() {
        return this.nickName;
    }

    public int getOnlineState() {
        return this.onlineState;
    }

    public GProMedal getPersonalMedal() {
        return this.personalMedal;
    }

    public int getPlatform() {
        return this.platform;
    }

    public int getRobotMuteStatus() {
        return this.robotMuteStatus;
    }

    public int getRobotPunishmentStatus() {
        return this.robotPunishmentStatus;
    }

    public String getRobotTestGuilds() {
        return this.robotTestGuilds;
    }

    public int getRobotType() {
        return this.robotType;
    }

    public GProRoleManagementTag getRoleManagementTag() {
        return this.roleManagementTag;
    }

    public long getShutUpExpireTime() {
        return this.shutUpExpireTime;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public int getType() {
        return this.type;
    }

    public GProVoiceInfo getVoiceInfo() {
        return this.voiceInfo;
    }

    public void setAllowScreenShare(int i2) {
        this.allowScreenShare = i2;
    }

    public void setAvatarMeta(String str) {
        this.avatarMeta = str;
    }

    public void setAvatarPendant(String str) {
        this.avatarPendant = str;
    }

    public void setBusinessInfo(GProBusinessInfo gProBusinessInfo) {
        this.businessInfo = gProBusinessInfo;
    }

    public void setChnRole(int i2) {
        this.chnRole = i2;
    }

    public void setClientIdentity(GProClientIdentity gProClientIdentity) {
        this.clientIdentity = gProClientIdentity;
    }

    public void setClientPresence(GProClientPresence gProClientPresence) {
        this.clientPresence = gProClientPresence;
    }

    public void setCookie(byte[] bArr) {
        this.cookie = bArr;
    }

    public void setGender(int i2) {
        this.gender = i2;
    }

    public void setGuildId(long j2) {
        this.guildId = j2;
    }

    public void setGuildMute(boolean z) {
        this.guildMute = z;
    }

    public void setInBlack(boolean z) {
        this.inBlack = z;
    }

    public void setJoinTime(long j2) {
        this.joinTime = j2;
    }

    public void setLevelRoleId(int i2) {
        this.levelRoleId = i2;
    }

    public void setMemberName(String str) {
        this.memberName = str;
    }

    public void setMyRoles(ArrayList<Integer> arrayList) {
        this.myRoles = arrayList;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setOnlineState(int i2) {
        this.onlineState = i2;
    }

    public void setPersonalMedal(GProMedal gProMedal) {
        this.personalMedal = gProMedal;
    }

    public void setPlatform(int i2) {
        this.platform = i2;
    }

    public void setRobotMuteStatus(int i2) {
        this.robotMuteStatus = i2;
    }

    public void setRobotPunishmentStatus(int i2) {
        this.robotPunishmentStatus = i2;
    }

    public void setRobotTestGuilds(String str) {
        this.robotTestGuilds = str;
    }

    public void setRobotType(int i2) {
        this.robotType = i2;
    }

    public void setRoleManagementTag(GProRoleManagementTag gProRoleManagementTag) {
        this.roleManagementTag = gProRoleManagementTag;
    }

    public void setShutUpExpireTime(long j2) {
        this.shutUpExpireTime = j2;
    }

    public void setTinyId(long j2) {
        this.tinyId = j2;
    }

    public void setType(int i2) {
        this.type = i2;
    }

    public void setVoiceInfo(GProVoiceInfo gProVoiceInfo) {
        this.voiceInfo = gProVoiceInfo;
    }

    public String toString() {
        return "GProUser{tinyId=" + this.tinyId + ",guildId=" + this.guildId + ",memberName=" + this.memberName + ",nickName=" + this.nickName + ",type=" + this.type + ",joinTime=" + this.joinTime + ",robotType=" + this.robotType + ",chnRole=" + this.chnRole + ",guildMute=" + this.guildMute + ",inBlack=" + this.inBlack + ",platform=" + this.platform + ",cookie=" + this.cookie + ",clientIdentity=" + this.clientIdentity + ",clientPresence=" + this.clientPresence + ",shutUpExpireTime=" + this.shutUpExpireTime + ",robotMuteStatus=" + this.robotMuteStatus + ",robotPunishmentStatus=" + this.robotPunishmentStatus + ",robotTestGuilds=" + this.robotTestGuilds + ",avatarMeta=" + this.avatarMeta + ",voiceInfo=" + this.voiceInfo + ",gender=" + this.gender + ",allowScreenShare=" + this.allowScreenShare + ",businessInfo=" + this.businessInfo + ",onlineState=" + this.onlineState + ",levelRoleId=" + this.levelRoleId + ",myRoles=" + this.myRoles + ",avatarPendant=" + this.avatarPendant + ",personalMedal=" + this.personalMedal + ",roleManagementTag=" + this.roleManagementTag + ",}";
    }

    public GProUser(long j2, long j3, String str, String str2, int i2, long j4, int i3, int i4, boolean z, boolean z2, int i5, byte[] bArr, GProClientIdentity gProClientIdentity, GProClientPresence gProClientPresence, long j5, int i6, int i7, String str3, String str4, GProVoiceInfo gProVoiceInfo, int i8, int i9, GProBusinessInfo gProBusinessInfo, int i10, int i11, ArrayList<Integer> arrayList, String str5, GProMedal gProMedal, GProRoleManagementTag gProRoleManagementTag) {
        this.serialVersionUID = 1L;
        this.memberName = "";
        this.nickName = "";
        this.cookie = new byte[0];
        this.clientIdentity = new GProClientIdentity();
        this.clientPresence = new GProClientPresence();
        this.robotTestGuilds = "";
        this.avatarMeta = "";
        this.voiceInfo = new GProVoiceInfo();
        this.businessInfo = new GProBusinessInfo();
        this.myRoles = new ArrayList<>();
        this.avatarPendant = "";
        this.personalMedal = new GProMedal();
        this.roleManagementTag = new GProRoleManagementTag();
        this.tinyId = j2;
        this.guildId = j3;
        this.memberName = str;
        this.nickName = str2;
        this.type = i2;
        this.joinTime = j4;
        this.robotType = i3;
        this.chnRole = i4;
        this.guildMute = z;
        this.inBlack = z2;
        this.platform = i5;
        this.cookie = bArr;
        this.clientIdentity = gProClientIdentity;
        this.clientPresence = gProClientPresence;
        this.shutUpExpireTime = j5;
        this.robotMuteStatus = i6;
        this.robotPunishmentStatus = i7;
        this.robotTestGuilds = str3;
        this.avatarMeta = str4;
        this.voiceInfo = gProVoiceInfo;
        this.gender = i8;
        this.allowScreenShare = i9;
        this.businessInfo = gProBusinessInfo;
        this.onlineState = i10;
        this.levelRoleId = i11;
        this.myRoles = arrayList;
        this.avatarPendant = str5;
        this.personalMedal = gProMedal;
        this.roleManagementTag = gProRoleManagementTag;
    }
}
