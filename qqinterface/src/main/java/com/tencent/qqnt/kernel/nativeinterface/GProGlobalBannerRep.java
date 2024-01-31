package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProGlobalBannerRep {
    String bannerId;
    int bannerType;
    long channelId;
    long guildId;
    long msgSeq;

    public GProGlobalBannerRep() {
        this.bannerId = "";
    }

    public String getBannerId() {
        return this.bannerId;
    }

    public int getBannerType() {
        return this.bannerType;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public long getMsgSeq() {
        return this.msgSeq;
    }

    public String toString() {
        return "GProGlobalBannerRep{guildId=" + this.guildId + ",channelId=" + this.channelId + ",bannerType=" + this.bannerType + ",msgSeq=" + this.msgSeq + ",bannerId=" + this.bannerId + ",}";
    }

    public GProGlobalBannerRep(long j2, long j3, int i2, long j4, String str) {
        this.bannerId = "";
        this.guildId = j2;
        this.channelId = j3;
        this.bannerType = i2;
        this.msgSeq = j4;
        this.bannerId = str;
    }
}
