package com.tencent.qqnt.kernel.nativeinterface;


public final class VideoPlayUrlInfo {
    String httpsDomain;
    boolean isHttps;
    String url;

    public VideoPlayUrlInfo() {
        this.url = "";
        this.httpsDomain = "";
    }

    public String getHttpsDomain() {
        return this.httpsDomain;
    }

    public boolean getIsHttps() {
        return this.isHttps;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "VideoPlayUrlInfo{url=" + this.url + ",isHttps=" + this.isHttps + ",httpsDomain=" + this.httpsDomain + ",}";
    }

    public VideoPlayUrlInfo(String str, boolean z, String str2) {
        this.url = "";
        this.httpsDomain = "";
        this.url = str;
        this.isHttps = z;
        this.httpsDomain = str2;
    }
}
