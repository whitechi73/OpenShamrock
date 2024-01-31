package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProFDLStFeed {
    String feedId;

    public GProFDLStFeed() {
        this.feedId = "";
    }

    public String getFeedId() {
        return this.feedId;
    }

    public String toString() {
        return "GProFDLStFeed{feedId=" + this.feedId + ",}";
    }

    public GProFDLStFeed(String str) {
        this.feedId = "";
        this.feedId = str;
    }
}
