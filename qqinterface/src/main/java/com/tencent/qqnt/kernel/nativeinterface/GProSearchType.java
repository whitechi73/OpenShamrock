package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProSearchType {
    int feedType;
    int msgType;
    int type;

    public GProSearchType() {
    }

    public int getFeedType() {
        return this.feedType;
    }

    public int getMsgType() {
        return this.msgType;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "GProSearchType{type=" + this.type + ",msgType=" + this.msgType + ",feedType=" + this.feedType + ",}";
    }

    public GProSearchType(int i2, int i3, int i4) {
        this.type = i2;
        this.msgType = i3;
        this.feedType = i4;
    }
}
