package com.tencent.qqnt.kernel.nativeinterface;


public  final class MultiTransInfo {
    int friendFlag;
    byte[] fromAnonId;
    String fromFaceUrl;
    int msgId;
    int status;

    public MultiTransInfo() {
        this.fromAnonId = new byte[0];
        this.fromFaceUrl = "";
    }

    public int getFriendFlag() {
        return this.friendFlag;
    }

    public byte[] getFromAnonId() {
        return this.fromAnonId;
    }

    public String getFromFaceUrl() {
        return this.fromFaceUrl;
    }

    public int getMsgId() {
        return this.msgId;
    }

    public int getStatus() {
        return this.status;
    }

    public String toString() {
        return "MultiTransInfo{status=" + this.status + ",msgId=" + this.msgId + ",friendFlag=" + this.friendFlag + ",fromAnonId=" + this.fromAnonId + ",fromFaceUrl=" + this.fromFaceUrl + ",}";
    }

    public MultiTransInfo(int i2, int i3, int i4, byte[] bArr, String str) {
        this.fromAnonId = new byte[0];
        this.fromFaceUrl = "";
        this.status = i2;
        this.msgId = i3;
        this.friendFlag = i4;
        this.fromAnonId = bArr;
        this.fromFaceUrl = str;
    }
}
