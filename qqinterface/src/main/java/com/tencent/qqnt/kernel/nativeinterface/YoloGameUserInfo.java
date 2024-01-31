package com.tencent.qqnt.kernel.nativeinterface;



public final class YoloGameUserInfo {
    String bizId;
    int rank;
    int result;
    String uid;

    public YoloGameUserInfo() {
        this.uid = "";
        this.bizId = "";
    }

    public String getBizId() {
        return this.bizId;
    }

    public int getRank() {
        return this.rank;
    }

    public int getResult() {
        return this.result;
    }

    public String getUid() {
        return this.uid;
    }

    public String toString() {
        return "YoloGameUserInfo{uid=" + this.uid + ",result=" + this.result + ",rank=" + this.rank + ",bizId=" + this.bizId + ",}";
    }

    public YoloGameUserInfo(String str, int i2, int i3, String str2) {
        this.uid = "";
        this.bizId = "";
        this.uid = str;
        this.result = i2;
        this.rank = i3;
        this.bizId = str2;
    }
}
