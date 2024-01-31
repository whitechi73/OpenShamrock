package com.tencent.qqnt.kernel.nativeinterface;


public  final class LocalAVRecordElement {
    String avAbstract;
    Integer extraType;
    boolean hasRead;
    long sendTime;
    int sendType;
    String senderUid;
    String text;
    long time;
    int type;

    public LocalAVRecordElement() {
        this.senderUid = "";
        this.text = "";
        this.avAbstract = "";
    }

    public String getAvAbstract() {
        return this.avAbstract;
    }

    public Integer getExtraType() {
        return this.extraType;
    }

    public boolean getHasRead() {
        return this.hasRead;
    }

    public long getSendTime() {
        return this.sendTime;
    }

    public int getSendType() {
        return this.sendType;
    }

    public String getSenderUid() {
        return this.senderUid;
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
        return "LocalAVRecordElement{type=" + this.type + ",time=" + this.time + ",senderUid=" + this.senderUid + ",sendType=" + this.sendType + ",text=" + this.text + ",avAbstract=" + this.avAbstract + ",hasRead=" + this.hasRead + ",sendTime=" + this.sendTime + ",extraType=" + this.extraType + ",}";
    }

    public LocalAVRecordElement(int i2, long j2, String str, int i3, String str2, String str3, boolean z, long j3, Integer num) {
        this.senderUid = "";
        this.text = "";
        this.avAbstract = "";
        this.type = i2;
        this.time = j2;
        this.senderUid = str;
        this.sendType = i3;
        this.text = str2;
        this.avAbstract = str3;
        this.hasRead = z;
        this.sendTime = j3;
        this.extraType = num;
    }
}
