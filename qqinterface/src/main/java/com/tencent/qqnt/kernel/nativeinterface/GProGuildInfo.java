package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

public final class GProGuildInfo implements Serializable {
    //static IPatchRedirector $redirector_;
    int allowSearch;
    GProMsgSeq authChannelChangeSeq;
    long bannedTimeLimit;
    long changeNameInterval;
    GProMsgSeq channelChangeSeq;
    int clientId;
    int coverFontColorId;
    long coverSeq;
    GProDirectMsgThreshold directMsgThreshold;
    GProExtendInfo extendInfo;
    long faceSeq;
    long groupId;
    int guildCanShare;
    long guildCode;
    GProMsgSeq guildInfoChangeSeq;
    String guildName;
    long guildNameChangeTime;
    String guildNumber;
    GProMsgSeq guildPermissionChanngeSeq;
    GProGroupProStatus guildStatus;
    boolean isGroupGuild;
    int isVisibleForVisitor;
    GProJumpInfo jumpInfo;
    int medalLevel;
    ArrayList<GProMedalInfo> medals;
    int memberNum;
    ArrayList<GProNavigationInfo> navigations;
    long ownerTinyid;
    String profile;
    int qrCodePeriod;
    int qrCodeSwitch;
    GProMsgSeq roleChangeSeq;
    long serialVersionUID;
    long shutupExpireTime;
    GProSpeakThreshold speakThreshold;
    GProTagInfo tagInfo;
    int topicSquareSwitch;
    int vistorFaceDistinguish;
    int vistorInteraction;

    public GProGuildInfo() {
        this.serialVersionUID = 1L;
        this.guildName = "";
        this.profile = "";
        this.guildStatus = new GProGroupProStatus();
        this.guildNumber = "";
        this.speakThreshold = new GProSpeakThreshold();
        this.directMsgThreshold = new GProDirectMsgThreshold();
        this.extendInfo = new GProExtendInfo();
        this.navigations = new ArrayList<>();
        this.jumpInfo = new GProJumpInfo();
        this.medals = new ArrayList<>();
        this.tagInfo = new GProTagInfo();
        this.guildInfoChangeSeq = new GProMsgSeq();
        this.channelChangeSeq = new GProMsgSeq();
        this.roleChangeSeq = new GProMsgSeq();
        this.authChannelChangeSeq = new GProMsgSeq();
        this.guildPermissionChanngeSeq = new GProMsgSeq();
    }

    public int getAllowSearch() {
       return 0;
    }

    public GProMsgSeq getAuthChannelChangeSeq() {
        return authChannelChangeSeq;
    }

    public long getBannedTimeLimit() {
        return 0;
    }

    public long getChangeNameInterval() {
        return 0;
    }

    public GProMsgSeq getChannelChangeSeq() {
        return null;
    }

    public int getClientId() {
        return 0;
    }

    public int getCoverFontColorId() {
        return 0;
    }

    public long getCoverSeq() {
        return 0;
    }

    public GProDirectMsgThreshold getDirectMsgThreshold() {
        return null;
    }

    public GProExtendInfo getExtendInfo() {
        return null;
    }

    public long getFaceSeq() {
        return 0;
    }

    public long getGroupId() {
        return 0;
    }

    public int getGuildCanShare() {
        return 0;
    }

    public long getGuildCode() {
        return 0;
    }

    public GProMsgSeq getGuildInfoChangeSeq() {
        return guildInfoChangeSeq;
    }

    public String getGuildName() {
        
        return "";
    }

    public long getGuildNameChangeTime() {
        
        return 0;
    }

    public String getGuildNumber() {
        
        return "";
    }

    public GProMsgSeq getGuildPermissionChanngeSeq() {
        
        return null;
    }

    public GProGroupProStatus getGuildStatus() {
        
        return null;
    }

    public boolean getIsGroupGuild() {
        
        return true;
    }

    public int getIsVisibleForVisitor() {
        
        return 0;
    }

    public GProJumpInfo getJumpInfo() {
        
        return null;
    }

    public int getMedalLevel() {
        
        return 0;
    }

    public ArrayList<GProMedalInfo> getMedals() {
        
        return medals;
    }

    public int getMemberNum() {
        
        return memberNum;
    }

    public ArrayList<GProNavigationInfo> getNavigations() {
        
        return navigations;
    }

    public long getOwnerTinyid() {
        
        return ownerTinyid;
    }

    public String getProfile() {
        
        return profile;
    }

    public int getQrCodePeriod() {
        
        return qrCodePeriod;
    }

    public int getQrCodeSwitch() {
        
        return qrCodeSwitch;
    }

    public GProMsgSeq getRoleChangeSeq() {
        
        return roleChangeSeq;
    }

    public long getShutupExpireTime() {
        
        return shutupExpireTime;
    }

    public GProSpeakThreshold getSpeakThreshold() {
        
        return speakThreshold;
    }

    public GProTagInfo getTagInfo() {

        return tagInfo;
    }

    public int getTopicSquareSwitch() {
        return topicSquareSwitch;
    }

    public int getVistorFaceDistinguish() {
        return vistorFaceDistinguish;
    }

    public int getVistorInteraction() {
        return vistorInteraction;
    }

    public String toString() {
        return "GProGuildInfo{guildCode=" + this.guildCode + ",memberNum=" + this.memberNum + ",guildName=" + this.guildName + ",profile=" + this.profile + ",faceSeq=" + this.faceSeq + ",guildStatus=" + this.guildStatus + ",ownerTinyid=" + this.ownerTinyid + ",coverSeq=" + this.coverSeq + ",clientId=" + this.clientId + ",shutupExpireTime=" + this.shutupExpireTime + ",bannedTimeLimit=" + this.bannedTimeLimit + ",coverFontColorId=" + this.coverFontColorId + ",guildCanShare=" + this.guildCanShare + ",qrCodePeriod=" + this.qrCodePeriod + ",guildNumber=" + this.guildNumber + ",guildNameChangeTime=" + this.guildNameChangeTime + ",allowSearch=" + this.allowSearch + ",isVisibleForVisitor=" + this.isVisibleForVisitor + ",speakThreshold=" + this.speakThreshold + ",directMsgThreshold=" + this.directMsgThreshold + ",extendInfo=" + this.extendInfo + ",navigations=" + this.navigations + ",jumpInfo=" + this.jumpInfo + ",vistorFaceDistinguish=" + this.vistorFaceDistinguish + ",vistorInteraction=" + this.vistorInteraction + ",medals=" + this.medals + ",topicSquareSwitch=" + this.topicSquareSwitch + ",groupId=" + this.groupId + ",isGroupGuild=" + this.isGroupGuild + ",tagInfo=" + this.tagInfo + ",qrCodeSwitch=" + this.qrCodeSwitch + ",guildInfoChangeSeq=" + this.guildInfoChangeSeq + ",channelChangeSeq=" + this.channelChangeSeq + ",roleChangeSeq=" + this.roleChangeSeq + ",authChannelChangeSeq=" + this.authChannelChangeSeq + ",guildPermissionChanngeSeq=" + this.guildPermissionChanngeSeq + ",medalLevel=" + this.medalLevel + ",changeNameInterval=" + this.changeNameInterval + ",}";
    }

    public GProGuildInfo(long j, int i, String str, String str2, long j2, GProGroupProStatus gProGroupProStatus, long j3, long j4, int i2, long j5, long j6, int i3, int i4, int i5, String str3, long j7, int i6, int i7, GProSpeakThreshold gProSpeakThreshold, GProDirectMsgThreshold gProDirectMsgThreshold, GProExtendInfo gProExtendInfo, ArrayList<GProNavigationInfo> arrayList, GProJumpInfo gProJumpInfo, int i8, int i9, ArrayList<GProMedalInfo> arrayList2, int i10, long j8, boolean z, GProTagInfo gProTagInfo, int i11, GProMsgSeq gProMsgSeq, GProMsgSeq gProMsgSeq2, GProMsgSeq gProMsgSeq3, GProMsgSeq gProMsgSeq4, GProMsgSeq gProMsgSeq5, int i12, long j9) {
        this.serialVersionUID = 1L;
        this.guildName = "";
        this.profile = "";
        this.guildStatus = new GProGroupProStatus();
        this.guildNumber = "";
        this.speakThreshold = new GProSpeakThreshold();
        this.directMsgThreshold = new GProDirectMsgThreshold();
        this.extendInfo = new GProExtendInfo();
        this.navigations = new ArrayList<>();
        this.jumpInfo = new GProJumpInfo();
        this.medals = new ArrayList<>();
        this.tagInfo = new GProTagInfo();
        this.guildInfoChangeSeq = new GProMsgSeq();
        this.channelChangeSeq = new GProMsgSeq();
        this.roleChangeSeq = new GProMsgSeq();
        this.authChannelChangeSeq = new GProMsgSeq();
        this.guildPermissionChanngeSeq = new GProMsgSeq();
        this.guildCode = j;
        this.memberNum = i;
        this.guildName = str;
        this.profile = str2;
        this.faceSeq = j2;
        this.guildStatus = gProGroupProStatus;
        this.ownerTinyid = j3;
        this.coverSeq = j4;
        this.clientId = i2;
        this.shutupExpireTime = j5;
        this.bannedTimeLimit = j6;
        this.coverFontColorId = i3;
        this.guildCanShare = i4;
        this.qrCodePeriod = i5;
        this.guildNumber = str3;
        this.guildNameChangeTime = j7;
        this.allowSearch = i6;
        this.isVisibleForVisitor = i7;
        this.speakThreshold = gProSpeakThreshold;
        this.directMsgThreshold = gProDirectMsgThreshold;
        this.extendInfo = gProExtendInfo;
        this.navigations = arrayList;
        this.jumpInfo = gProJumpInfo;
        this.vistorFaceDistinguish = i8;
        this.vistorInteraction = i9;
        this.medals = arrayList2;
        this.topicSquareSwitch = i10;
        this.groupId = j8;
        this.isGroupGuild = z;
        this.tagInfo = gProTagInfo;
        this.qrCodeSwitch = i11;
        this.guildInfoChangeSeq = gProMsgSeq;
        this.channelChangeSeq = gProMsgSeq2;
        this.roleChangeSeq = gProMsgSeq3;
        this.authChannelChangeSeq = gProMsgSeq4;
        this.guildPermissionChanngeSeq = gProMsgSeq5;
        this.medalLevel = i12;
        this.changeNameInterval = j9;
    }
}
