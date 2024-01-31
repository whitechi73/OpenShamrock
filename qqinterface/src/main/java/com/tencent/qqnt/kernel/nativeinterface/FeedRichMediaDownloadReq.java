package com.tencent.qqnt.kernel.nativeinterface;


public  final class FeedRichMediaDownloadReq {
    String feedId;
    Integer feedsType;
    String fileId;
    FeedFileType fileType;
    Integer levelType;
    String savePath;
    String subId;

    public FeedRichMediaDownloadReq() {
        this.feedId = "";
        this.fileId = "";
        this.fileType = FeedFileType.values()[0];
        this.savePath = "";
    }

    public String getFeedId() {
        return this.feedId;
    }

    public Integer getFeedsType() {
        return this.feedsType;
    }

    public String getFileId() {
        return this.fileId;
    }

    public FeedFileType getFileType() {
        return this.fileType;
    }

    public Integer getLevelType() {
        return this.levelType;
    }

    public String getSavePath() {
        return this.savePath;
    }

    public String getSubId() {
        return this.subId;
    }

    public String toString() {
        return "FeedRichMediaDownloadReq{feedId=" + this.feedId + ",subId=" + this.subId + ",fileId=" + this.fileId + ",fileType=" + this.fileType + ",levelType=" + this.levelType + ",savePath=" + this.savePath + ",feedsType=" + this.feedsType + ",}";
    }

    public FeedRichMediaDownloadReq(String str, String str2, String str3, FeedFileType feedFileType, Integer num, String str4, Integer num2) {
        this.feedId = "";
        this.fileId = "";
        this.fileType = FeedFileType.values()[0];
        this.savePath = "";
        this.feedId = str;
        this.subId = str2;
        this.fileId = str3;
        this.fileType = feedFileType;
        this.levelType = num;
        this.savePath = str4;
        this.feedsType = num2;
    }
}
