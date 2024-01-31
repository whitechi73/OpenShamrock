package com.tencent.qqnt.kernel.nativeinterface;


public  final class FileTransNotifyInfo {
    int businessId;
    String clientMsg;
    CommonFileInfo commonFileInfo;
    int fileDownType;
    long fileErrCode;
    String fileErrMsg;
    String fileId;
    long fileModelId;
    String filePath;
    long fileProgress;
    long fileSpeed;
    long fileSrvErrCode;
    long msgElementId;
    long msgId;
    int step;
    int thumbSize;
    long totalSize;
    int trasferStatus;

    public FileTransNotifyInfo() {
        this.fileId = "";
        this.fileErrMsg = "";
        this.filePath = "";
        this.clientMsg = "";
    }

    public int getBusinessId() {
        return this.businessId;
    }

    public String getClientMsg() {
        return this.clientMsg;
    }

    public CommonFileInfo getCommonFileInfo() {
        return this.commonFileInfo;
    }

    public int getFileDownType() {
        return this.fileDownType;
    }

    public long getFileErrCode() {
        return this.fileErrCode;
    }

    public String getFileErrMsg() {
        return this.fileErrMsg;
    }

    public String getFileId() {
        return this.fileId;
    }

    public long getFileModelId() {
        return this.fileModelId;
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

    public long getFileSrvErrCode() {
        return this.fileSrvErrCode;
    }

    public long getMsgElementId() {
        return this.msgElementId;
    }

    public long getMsgId() {
        return this.msgId;
    }

    public int getStep() {
        return this.step;
    }

    public int getThumbSize() {
        return this.thumbSize;
    }

    public long getTotalSize() {
        return this.totalSize;
    }

    public int getTrasferStatus() {
        return this.trasferStatus;
    }

    public String toString() {
        return "FileTransNotifyInfo{fileModelId=" + this.fileModelId + ",msgElementId=" + this.msgElementId + ",msgId=" + this.msgId + ",fileId=" + this.fileId + ",fileProgress=" + this.fileProgress + ",fileSpeed=" + this.fileSpeed + ",fileErrCode=" + this.fileErrCode + ",fileErrMsg=" + this.fileErrMsg + ",fileDownType=" + this.fileDownType + ",thumbSize=" + this.thumbSize + ",filePath=" + this.filePath + ",totalSize=" + this.totalSize + ",trasferStatus=" + this.trasferStatus + ",step=" + this.step + ",commonFileInfo=" + this.commonFileInfo + ",fileSrvErrCode=" + this.fileSrvErrCode + ",clientMsg=" + this.clientMsg + ",businessId=" + this.businessId + ",}";
    }

    public FileTransNotifyInfo(long j2, long j3, long j4, String str, long j5, long j6, long j7, String str2, int i2, int i3, String str3, long j8, int i4, int i5, CommonFileInfo commonFileInfo, long j9, String str4, int i6) {
        this.fileId = "";
        this.fileErrMsg = "";
        this.filePath = "";
        this.clientMsg = "";
        this.fileModelId = j2;
        this.msgElementId = j3;
        this.msgId = j4;
        this.fileId = str;
        this.fileProgress = j5;
        this.fileSpeed = j6;
        this.fileErrCode = j7;
        this.fileErrMsg = str2;
        this.fileDownType = i2;
        this.thumbSize = i3;
        this.filePath = str3;
        this.totalSize = j8;
        this.trasferStatus = i4;
        this.step = i5;
        this.commonFileInfo = commonFileInfo;
        this.fileSrvErrCode = j9;
        this.clientMsg = str4;
        this.businessId = i6;
    }
}
