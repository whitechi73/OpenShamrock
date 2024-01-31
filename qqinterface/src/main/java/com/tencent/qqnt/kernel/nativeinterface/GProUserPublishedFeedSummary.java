package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public  final class GProUserPublishedFeedSummary {
    ArrayList<byte[]> feedList;
    String publishedCountStr;

    public GProUserPublishedFeedSummary() {
        this.publishedCountStr = "";
        this.feedList = new ArrayList<>();
    }

    public ArrayList<byte[]> getFeedList() {
        return this.feedList;
    }

    public String getPublishedCountStr() {
        return this.publishedCountStr;
    }

    public String toString() {
        return "GProUserPublishedFeedSummary{publishedCountStr=" + this.publishedCountStr + ",feedList=" + this.feedList + ",}";
    }

    public GProUserPublishedFeedSummary(String str, ArrayList<byte[]> arrayList) {
        this.publishedCountStr = "";
        this.feedList = new ArrayList<>();
        this.publishedCountStr = str;
        this.feedList = arrayList;
    }
}
