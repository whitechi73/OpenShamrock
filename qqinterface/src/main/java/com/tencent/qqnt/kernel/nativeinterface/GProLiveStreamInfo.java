package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public  final class GProLiveStreamInfo implements Serializable {
    long anchorId;
    String flvUrl;
    long serialVersionUID;
    String url;

    public GProLiveStreamInfo() {
        this.serialVersionUID = 1L;
        this.url = "";
        this.flvUrl = "";
    }

    public long getAnchorId() {
        return this.anchorId;
    }

    public String getFlvUrl() {
        return this.flvUrl;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "GProLiveStreamInfo{url=" + this.url + ",anchorId=" + this.anchorId + ",flvUrl=" + this.flvUrl + ",}";
    }

    public GProLiveStreamInfo(String str, long j2, String str2) {
        this.serialVersionUID = 1L;
        this.url = "";
        this.flvUrl = "";
        this.url = str;
        this.anchorId = j2;
        this.flvUrl = str2;
    }
}
