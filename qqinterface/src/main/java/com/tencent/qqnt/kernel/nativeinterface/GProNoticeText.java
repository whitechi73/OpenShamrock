package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProNoticeText {
    String content;
    long linkId;
    int type;

    public GProNoticeText() {
        this.content = "";
    }

    public String getContent() {
        return this.content;
    }

    public long getLinkId() {
        return this.linkId;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "GProNoticeText{type=" + this.type + ",content=" + this.content + ",linkId=" + this.linkId + ",}";
    }

    public GProNoticeText(int i2, String str, long j2) {
        this.content = "";
        this.type = i2;
        this.content = str;
        this.linkId = j2;
    }
}
