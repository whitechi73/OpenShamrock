package com.tencent.qqnt.kernel.nativeinterface;

public final class AVRecordElement {
    Integer extraType;
    boolean hasRead;
    int mainType;
    String text;
    long time;
    int type;

    public AVRecordElement() {
        this.text = "";
    }

    public Integer getExtraType() {
        return this.extraType;
    }

    public boolean getHasRead() {
        return this.hasRead;
    }

    public int getMainType() {
        return this.mainType;
    }

    public String getText() {
        return this.text;
    }

    public long getTime() {
        return this.time;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "AVRecordElement{type=" + this.type + ",time=" + this.time + ",text=" + this.text + ",mainType=" + this.mainType + ",hasRead=" + this.hasRead + ",extraType=" + this.extraType + ",}";
    }

    public AVRecordElement(int i2, long j2, String str, int i3, boolean z, Integer num) {
        this.text = "";
        this.type = i2;
        this.time = j2;
        this.text = str;
        this.mainType = i3;
        this.hasRead = z;
        this.extraType = num;
    }
}