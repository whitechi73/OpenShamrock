package com.tencent.qqnt.kernel.nativeinterface;


public  final class FeedUrlDownloadReq {
    String savePath;
    String url;

    public FeedUrlDownloadReq() {
        this.url = "";
        this.savePath = "";
    }

    public String getSavePath() {
        return this.savePath;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "FeedUrlDownloadReq{url=" + this.url + ",savePath=" + this.savePath + ",}";
    }

    public FeedUrlDownloadReq(String str, String str2) {
        this.url = "";
        this.savePath = "";
        this.url = str;
        this.savePath = str2;
    }
}
