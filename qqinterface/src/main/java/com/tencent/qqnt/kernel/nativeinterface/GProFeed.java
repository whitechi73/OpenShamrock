package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public  final class GProFeed implements Serializable {
    String feedId;
    long serialVersionUID;

    public GProFeed() {
        this.serialVersionUID = 1L;
        this.feedId = "";
    }

    public String getFeedId() {
        return this.feedId;
    }

    public String toString() {
        return "GProFeed{feedId=" + this.feedId + ",}";
    }

    public GProFeed(String str) {
        this.serialVersionUID = 1L;
        this.feedId = "";
        this.feedId = str;
    }
}
