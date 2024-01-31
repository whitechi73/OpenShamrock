package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProRecommendInfo {
    GProRecommendChannel channel;
    GProRecommendFeed feed;
    GProRecommendShareInfo shareInfo;
    int type;

    public GProRecommendInfo() {
        this.feed = new GProRecommendFeed();
        this.channel = new GProRecommendChannel();
        this.shareInfo = new GProRecommendShareInfo();
    }

    public GProRecommendChannel getChannel() {
        return this.channel;
    }

    public GProRecommendFeed getFeed() {
        return this.feed;
    }

    public GProRecommendShareInfo getShareInfo() {
        return this.shareInfo;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "GProRecommendInfo{feed=" + this.feed + ",channel=" + this.channel + ",shareInfo=" + this.shareInfo + ",type=" + this.type + ",}";
    }

    public GProRecommendInfo(GProRecommendFeed gProRecommendFeed, GProRecommendChannel gProRecommendChannel, GProRecommendShareInfo gProRecommendShareInfo, int i2) {
        this.feed = new GProRecommendFeed();
        this.channel = new GProRecommendChannel();
        this.shareInfo = new GProRecommendShareInfo();
        this.feed = gProRecommendFeed;
        this.channel = gProRecommendChannel;
        this.shareInfo = gProRecommendShareInfo;
        this.type = i2;
    }
}
