package com.tencent.qqnt.kernel.nativeinterface;

public final class GroupSpaceResult {
    boolean allUpload;
    String clientWording;
    int retCode;
    String retMsg;
    long totalSpace;
    long usedSpace;

    public GroupSpaceResult() {
        this.retMsg = "";
        this.clientWording = "";
    }

    public boolean getAllUpload() {
        return this.allUpload;
    }

    public String getClientWording() {
        return this.clientWording;
    }

    public int getRetCode() {
        return this.retCode;
    }

    public String getRetMsg() {
        return this.retMsg;
    }

    public long getTotalSpace() {
        return this.totalSpace;
    }

    public long getUsedSpace() {
        return this.usedSpace;
    }

    public String toString() {
        return "GroupSpaceResult{retCode=" + this.retCode + ",retMsg=" + this.retMsg + ",clientWording=" + this.clientWording + ",totalSpace=" + this.totalSpace + ",usedSpace=" + this.usedSpace + ",allUpload=" + this.allUpload + ",}";
    }

    public GroupSpaceResult(int i2, String str, String str2, long j2, long j3, boolean z) {
        this.retMsg = "";
        this.clientWording = "";
        this.retCode = i2;
        this.retMsg = str;
        this.clientWording = str2;
        this.totalSpace = j2;
        this.usedSpace = j3;
        this.allUpload = z;
    }
}
