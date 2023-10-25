package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProRecommendChannelInfo implements Serializable {
    long channelId;
    String channelName;
    int channelType;
    String coverUrl;
    String guildIcon;
    long guildId;
    String guildName;
    String guildNumber;
    String guildProfile;
    int isWhole;
    String itemId;
    String joinGuildSig;
    int joinedGuild;
    ArrayList<GProMedalInfo> medalInfoList;
    int medalLevel;
    int memberRole;
    GProRecommendSeqInfo seqInfo;
    long serialVersionUID;
    String shareLink;
    int shareTag;
    ArrayList<GProRecommendGuildState> stateList;
    ArrayList<GProRecommendLabel> tagList;
    String titleName;
    long unreadAtMeCount;

    public GProRecommendChannelInfo() {
        this.serialVersionUID = 1L;
        this.guildName = "";
        this.guildIcon = "";
        this.guildProfile = "";
        this.stateList = new ArrayList<>();
        this.shareLink = "";
        this.coverUrl = "";
        this.joinGuildSig = "";
        this.channelName = "";
        this.itemId = "";
        this.tagList = new ArrayList<>();
        this.seqInfo = new GProRecommendSeqInfo();
        this.guildNumber = "";
        this.titleName = "";
        this.medalInfoList = new ArrayList<>();
    }

    public long getChannelId() {
        return this.channelId;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public int getChannelType() {
        return this.channelType;
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public String getGuildIcon() {
        return this.guildIcon;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getGuildName() {
        return this.guildName;
    }

    public String getGuildNumber() {
        return this.guildNumber;
    }

    public String getGuildProfile() {
        return this.guildProfile;
    }

    public int getIsWhole() {
        return this.isWhole;
    }

    public String getItemId() {
        return this.itemId;
    }

    public String getJoinGuildSig() {
        return this.joinGuildSig;
    }

    public int getJoinedGuild() {
        return this.joinedGuild;
    }

    public ArrayList<GProMedalInfo> getMedalInfoList() {
        return this.medalInfoList;
    }

    public int getMedalLevel() {
        return this.medalLevel;
    }

    public int getMemberRole() {
        return this.memberRole;
    }

    public GProRecommendSeqInfo getSeqInfo() {
        return this.seqInfo;
    }

    public String getShareLink() {
        return this.shareLink;
    }

    public int getShareTag() {
        return this.shareTag;
    }

    public ArrayList<GProRecommendGuildState> getStateList() {
        return this.stateList;
    }

    public ArrayList<GProRecommendLabel> getTagList() {
        return this.tagList;
    }

    public String getTitleName() {
        return this.titleName;
    }

    public long getUnreadAtMeCount() {
        return this.unreadAtMeCount;
    }

    public String toString() {
        return "GProRecommendChannelInfo{guildId=" + this.guildId + ",guildName=" + this.guildName + ",guildIcon=" + this.guildIcon + ",guildProfile=" + this.guildProfile + ",stateList=" + this.stateList + ",shareLink=" + this.shareLink + ",joinedGuild=" + this.joinedGuild + ",coverUrl=" + this.coverUrl + ",joinGuildSig=" + this.joinGuildSig + ",memberRole=" + this.memberRole + ",channelId=" + this.channelId + ",channelName=" + this.channelName + ",channelType=" + this.channelType + ",itemId=" + this.itemId + ",tagList=" + this.tagList + ",seqInfo=" + this.seqInfo + ",guildNumber=" + this.guildNumber + ",medalLevel=" + this.medalLevel + ",titleName=" + this.titleName + ",shareTag=" + this.shareTag + ",isWhole=" + this.isWhole + ",unreadAtMeCount=" + this.unreadAtMeCount + ",medalInfoList=" + this.medalInfoList + ",}";
    }

    public GProRecommendChannelInfo(long j2, String str, String str2, String str3, ArrayList<GProRecommendGuildState> arrayList, String str4, int i2, String str5, String str6, int i3, long j3, String str7, int i4, String str8, ArrayList<GProRecommendLabel> arrayList2, GProRecommendSeqInfo gProRecommendSeqInfo, String str9, int i5, String str10, int i6, int i7, long j4, ArrayList<GProMedalInfo> arrayList3) {
        this.serialVersionUID = 1L;
        this.guildName = "";
        this.guildIcon = "";
        this.guildProfile = "";
        this.stateList = new ArrayList<>();
        this.shareLink = "";
        this.coverUrl = "";
        this.joinGuildSig = "";
        this.channelName = "";
        this.itemId = "";
        this.tagList = new ArrayList<>();
        this.seqInfo = new GProRecommendSeqInfo();
        this.guildNumber = "";
        this.titleName = "";
        this.medalInfoList = new ArrayList<>();
        this.guildId = j2;
        this.guildName = str;
        this.guildIcon = str2;
        this.guildProfile = str3;
        this.stateList = arrayList;
        this.shareLink = str4;
        this.joinedGuild = i2;
        this.coverUrl = str5;
        this.joinGuildSig = str6;
        this.memberRole = i3;
        this.channelId = j3;
        this.channelName = str7;
        this.channelType = i4;
        this.itemId = str8;
        this.tagList = arrayList2;
        this.seqInfo = gProRecommendSeqInfo;
        this.guildNumber = str9;
        this.medalLevel = i5;
        this.titleName = str10;
        this.shareTag = i6;
        this.isWhole = i7;
        this.unreadAtMeCount = j4;
        this.medalInfoList = arrayList3;
    }
}
