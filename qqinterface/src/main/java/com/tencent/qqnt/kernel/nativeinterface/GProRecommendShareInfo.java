package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public  final class GProRecommendShareInfo implements Serializable {
    GProBusinessData bizData;
    long channelId;
    String guildCoverUrl;
    String guildIcon;
    long guildId;
    String guildName;
    String joinGuildSig;
    int joinedGuild;
    int memberRole;
    long serialVersionUID;
    String shareLink;
    GProRecommendShareLive shareLive;
    int shareTag;
    int shareType;

    public GProRecommendShareInfo() {
        this.serialVersionUID = 1L;
        this.shareLink = "";
        this.guildName = "";
        this.guildIcon = "";
        this.shareLive = new GProRecommendShareLive();
        this.guildCoverUrl = "";
        this.joinGuildSig = "";
        this.bizData = new GProBusinessData();
    }

    public GProBusinessData getBizData() {
        return this.bizData;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public String getGuildCoverUrl() {
        return this.guildCoverUrl;
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

    public String getJoinGuildSig() {
        return this.joinGuildSig;
    }

    public int getJoinedGuild() {
        return this.joinedGuild;
    }

    public int getMemberRole() {
        return this.memberRole;
    }

    public String getShareLink() {
        return this.shareLink;
    }

    public GProRecommendShareLive getShareLive() {
        return this.shareLive;
    }

    public int getShareTag() {
        return this.shareTag;
    }

    public int getShareType() {
        return this.shareType;
    }

    public String toString() {
        return "GProRecommendShareInfo{shareLink=" + this.shareLink + ",guildName=" + this.guildName + ",guildIcon=" + this.guildIcon + ",shareType=" + this.shareType + ",shareLive=" + this.shareLive + ",guildId=" + this.guildId + ",guildCoverUrl=" + this.guildCoverUrl + ",joinedGuild=" + this.joinedGuild + ",joinGuildSig=" + this.joinGuildSig + ",channelId=" + this.channelId + ",bizData=" + this.bizData + ",memberRole=" + this.memberRole + ",shareTag=" + this.shareTag + ",}";
    }

    public GProRecommendShareInfo(String str, String str2, String str3, int i2, GProRecommendShareLive gProRecommendShareLive, long j2, String str4, int i3, String str5, long j3, GProBusinessData gProBusinessData, int i4, int i5) {
        this.serialVersionUID = 1L;
        this.shareLink = "";
        this.guildName = "";
        this.guildIcon = "";
        this.shareLive = new GProRecommendShareLive();
        this.guildCoverUrl = "";
        this.joinGuildSig = "";
        this.bizData = new GProBusinessData();
        this.shareLink = str;
        this.guildName = str2;
        this.guildIcon = str3;
        this.shareType = i2;
        this.shareLive = gProRecommendShareLive;
        this.guildId = j2;
        this.guildCoverUrl = str4;
        this.joinedGuild = i3;
        this.joinGuildSig = str5;
        this.channelId = j3;
        this.bizData = gProBusinessData;
        this.memberRole = i4;
        this.shareTag = i5;
    }
}
