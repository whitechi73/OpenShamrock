package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProRecommendGroupInfo {
    ArrayList<GProRecommendChannel> channelList;
    GProRecommendFeed feed;

    public GProRecommendGroupInfo() {
        this.feed = new GProRecommendFeed();
        this.channelList = new ArrayList<>();
    }

    public ArrayList<GProRecommendChannel> getChannelList() {
        return this.channelList;
    }

    public GProRecommendFeed getFeed() {
        return this.feed;
    }

    public String toString() {
        return "GProRecommendGroupInfo{feed=" + this.feed + ",channelList=" + this.channelList + ",}";
    }

    public GProRecommendGroupInfo(GProRecommendFeed gProRecommendFeed, ArrayList<GProRecommendChannel> arrayList) {
        this.feed = new GProRecommendFeed();
        this.channelList = new ArrayList<>();
        this.feed = gProRecommendFeed;
        this.channelList = arrayList;
    }
}
