package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProFeedReportData {
    GProFeed feed;

    public GProFeedReportData() {
        this.feed = new GProFeed();
    }

    public GProFeed getFeed() {
        return this.feed;
    }

    public String toString() {
        return "GProFeedReportData{feed=" + this.feed + ",}";
    }

    public GProFeedReportData(GProFeed gProFeed) {
        this.feed = new GProFeed();
        this.feed = gProFeed;
    }
}
