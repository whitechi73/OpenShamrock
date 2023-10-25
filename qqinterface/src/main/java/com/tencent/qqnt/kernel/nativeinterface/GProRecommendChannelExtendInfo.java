package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProRecommendChannelExtendInfo {
    int areaType;
    long channelId;
    String channelLink;
    int channelLinkType;
    String guildFace;
    int hideVisitorStyle;

    public GProRecommendChannelExtendInfo() {
        this.channelLink = "";
        this.guildFace = "";
    }

    public int getAreaType() {
        return this.areaType;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public String getChannelLink() {
        return this.channelLink;
    }

    public int getChannelLinkType() {
        return this.channelLinkType;
    }

    public String getGuildFace() {
        return this.guildFace;
    }

    public int getHideVisitorStyle() {
        return this.hideVisitorStyle;
    }

    public String toString() {
        return "GProRecommendChannelExtendInfo{channelId=" + this.channelId + ",channelLink=" + this.channelLink + ",guildFace=" + this.guildFace + ",areaType=" + this.areaType + ",channelLinkType=" + this.channelLinkType + ",hideVisitorStyle=" + this.hideVisitorStyle + ",}";
    }

    public GProRecommendChannelExtendInfo(long j2, String str, String str2, int i2, int i3, int i4) {
        this.channelLink = "";
        this.guildFace = "";
        this.channelId = j2;
        this.channelLink = str;
        this.guildFace = str2;
        this.areaType = i2;
        this.channelLinkType = i3;
        this.hideVisitorStyle = i4;
    }
}
