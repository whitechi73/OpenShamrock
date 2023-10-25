package com.tencent.qqnt.kernel.nativeinterface;

public final class BulletinFeedsDownloadInfo {
    BulletinFeedsFileType downloadType;
    int errorCode;
    String errorMsg;
    String feedsId;
    String fileId;
    String fileName;
    int levelType;
    long progress;
    String savePath;
    String url;

    public BulletinFeedsDownloadInfo() {
        this.errorMsg = "";
        this.feedsId = "";
        this.fileId = "";
        this.downloadType = BulletinFeedsFileType.values()[0];
        this.fileName = "";
        this.url = "";
        this.savePath = "";
    }

    public BulletinFeedsFileType getDownloadType() {
        return this.downloadType;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public String getFeedsId() {
        return this.feedsId;
    }

    public String getFileId() {
        return this.fileId;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int getLevelType() {
        return this.levelType;
    }

    public long getProgress() {
        return this.progress;
    }

    public String getSavePath() {
        return this.savePath;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "BulletinFeedsDownloadInfo{errorCode=" + this.errorCode + ",errorMsg=" + this.errorMsg + ",progress=" + this.progress + ",feedsId=" + this.feedsId + ",fileId=" + this.fileId + ",downloadType=" + this.downloadType + ",fileName=" + this.fileName + ",levelType=" + this.levelType + this.url + ",savePath=" + this.savePath + ",}";
    }

    public BulletinFeedsDownloadInfo(int i2, String str, long j2, String str2, String str3, BulletinFeedsFileType bulletinFeedsFileType, String str4, int i3, String str5, String str6) {
        this.errorMsg = "";
        this.feedsId = "";
        this.fileId = "";
        this.downloadType = BulletinFeedsFileType.values()[0];
        this.fileName = "";
        this.url = "";
        this.savePath = "";
        this.errorCode = i2;
        this.errorMsg = str;
        this.progress = j2;
        this.feedsId = str2;
        this.fileId = str3;
        this.downloadType = bulletinFeedsFileType;
        this.fileName = str4;
        this.levelType = i3;
        this.url = str5;
        this.savePath = str6;
    }
}