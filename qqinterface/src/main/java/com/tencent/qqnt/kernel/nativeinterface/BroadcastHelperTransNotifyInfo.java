package com.tencent.qqnt.kernel.nativeinterface;

public final class BroadcastHelperTransNotifyInfo {
    long fileErrCode;
    String fileErrMsg;
    String filePath;
    long fileProgress;
    long fileSpeed;
    long totalSize;
    int trasferStatus;

    public BroadcastHelperTransNotifyInfo() {
        this.fileErrMsg = "";
        this.filePath = "";
    }

    public long getFileErrCode() {
        return this.fileErrCode;
    }

    public String getFileErrMsg() {
        return this.fileErrMsg;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public long getFileProgress() {
        return this.fileProgress;
    }

    public long getFileSpeed() {
        return this.fileSpeed;
    }

    public long getTotalSize() {
        return this.totalSize;
    }

    public int getTrasferStatus() {
        return this.trasferStatus;
    }

    public String toString() {
        return "BroadcastHelperTransNotifyInfo{fileProgress=" + this.fileProgress + ",fileSpeed=" + this.fileSpeed + ",fileErrCode=" + this.fileErrCode + ",fileErrMsg=" + this.fileErrMsg + ",filePath=" + this.filePath + ",totalSize=" + this.totalSize + ",trasferStatus=" + this.trasferStatus + ",}";
    }

    public BroadcastHelperTransNotifyInfo(long j2, long j3, long j4, String str, String str2, long j5, int i2) {
        this.fileErrMsg = "";
        this.filePath = "";
        this.fileProgress = j2;
        this.fileSpeed = j3;
        this.fileErrCode = j4;
        this.fileErrMsg = str;
        this.filePath = str2;
        this.totalSize = j5;
        this.trasferStatus = i2;
    }
}