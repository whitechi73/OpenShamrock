package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProTopFeed {
    long createTime;
    GProTopFeedAbstract feedAbstract;
    String feedId;
    long operatorTinyId;
    long topTimestamp;
    String userId;

    public GProTopFeed() {
        this.feedId = "";
        this.userId = "";
        this.feedAbstract = new GProTopFeedAbstract();
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public GProTopFeedAbstract getFeedAbstract() {
        return this.feedAbstract;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public long getOperatorTinyId() {
        return this.operatorTinyId;
    }

    public long getTopTimestamp() {
        return this.topTimestamp;
    }

    public String getUserId() {
        return this.userId;
    }

    public String toString() {
        return "GProTopFeed{feedId=" + this.feedId + ",userId=" + this.userId + ",createTime=" + this.createTime + ",feedAbstract=" + this.feedAbstract + ",topTimestamp=" + this.topTimestamp + ",operatorTinyId=" + this.operatorTinyId + ",}";
    }

    public GProTopFeed(String str, String str2, long j2, GProTopFeedAbstract gProTopFeedAbstract, long j3, long j4) {
        this.feedId = "";
        this.userId = "";
        this.feedAbstract = new GProTopFeedAbstract();
        this.feedId = str;
        this.userId = str2;
        this.createTime = j2;
        this.feedAbstract = gProTopFeedAbstract;
        this.topTimestamp = j3;
        this.operatorTinyId = j4;
    }
}
