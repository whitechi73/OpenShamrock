package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public final class FeedMsgElement implements Serializable {
    String content;
    long serialVersionUID;
    long tinyId;

    public FeedMsgElement() {
        this.serialVersionUID = 1L;
        this.content = "";
    }

    public String getContent() {
        return this.content;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public String toString() {
        return "FeedMsgElement{tinyId=" + this.tinyId + ",content=" + this.content + ",}";
    }

    public FeedMsgElement(long j2, String str) {
        this.serialVersionUID = 1L;
        this.content = "";
        this.tinyId = j2;
        this.content = str;
    }
}