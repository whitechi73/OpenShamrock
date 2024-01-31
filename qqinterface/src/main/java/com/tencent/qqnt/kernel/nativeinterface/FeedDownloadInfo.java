package com.tencent.qqnt.kernel.nativeinterface;


public  final class FeedDownloadInfo {
    FeedFileType downloadType;
    int errorCode;
    String errorMsg;
    String feedId;
    String fileId;
    String fileName;
    int levelType;
    long progress;
    String savePath;
    String subId;
    String url;

    public FeedDownloadInfo() {
        this.errorMsg = "";
        this.feedId = "";
        this.subId = "";
        this.fileId = "";
        this.downloadType = FeedFileType.values()[0];
        this.fileName = "";
        this.url = "";
        this.savePath = "";
    }

    public FeedFileType getDownloadType() {
        return this.downloadType;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public String getFeedId() {
        return this.feedId;
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

    public String getSubId() {
        return this.subId;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "FeedDownloadInfo{errorCode=" + this.errorCode + ",errorMsg=" + this.errorMsg + ",progress=" + this.progress + ",feedId=" + this.feedId + ",subId=" + this.subId + ",fileId=" + this.fileId + ",downloadType=" + this.downloadType + ",fileName=" + this.fileName + ",levelType=" + this.levelType + "" + this.url + ",savePath=" + this.savePath + ",}";
    }

    public FeedDownloadInfo(int i2, String str, long j2, String str2, String str3, String str4, FeedFileType feedFileType, String str5, int i3, String str6, String str7) {
        this.errorMsg = "";
        this.feedId = "";
        this.subId = "";
        this.fileId = "";
        this.downloadType = FeedFileType.values()[0];
        this.fileName = "";
        this.url = "";
        this.savePath = "";
        this.errorCode = i2;
        this.errorMsg = str;
        this.progress = j2;
        this.feedId = str2;
        this.subId = str3;
        this.fileId = str4;
        this.downloadType = feedFileType;
        this.fileName = str5;
        this.levelType = i3;
        this.url = str6;
        this.savePath = str7;
    }
}
