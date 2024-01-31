package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProGuildBannerBizId {
    int bannerType;
    long channelId;
    long feedCreateTime;
    long feedCreateTinyId;
    String feedId;
    long msgSeq;
    String thirdRecommendId;

    public GProGuildBannerBizId() {
        this.feedId = "";
        this.thirdRecommendId = "";
    }

    public int getBannerType() {
        return this.bannerType;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getFeedCreateTime() {
        return this.feedCreateTime;
    }

    public long getFeedCreateTinyId() {
        return this.feedCreateTinyId;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public long getMsgSeq() {
        return this.msgSeq;
    }

    public String getThirdRecommendId() {
        return this.thirdRecommendId;
    }

    public String toString() {
        return "GProGuildBannerBizId{bannerType=" + this.bannerType + ",channelId=" + this.channelId + ",msgSeq=" + this.msgSeq + ",feedId=" + this.feedId + ",feedCreateTime=" + this.feedCreateTime + ",feedCreateTinyId=" + this.feedCreateTinyId + ",thirdRecommendId=" + this.thirdRecommendId + ",}";
    }

    public GProGuildBannerBizId(int i2, long j2, long j3, String str, long j4, long j5, String str2) {
        this.feedId = "";
        this.thirdRecommendId = "";
        this.bannerType = i2;
        this.channelId = j2;
        this.msgSeq = j3;
        this.feedId = str;
        this.feedCreateTime = j4;
        this.feedCreateTinyId = j5;
        this.thirdRecommendId = str2;
    }
}
