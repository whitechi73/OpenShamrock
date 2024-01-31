package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public  final class GProRecommendCoverInfo implements Serializable {
    String imageUrl;
    long serialVersionUID;
    String streamUrl;
    int type;

    public GProRecommendCoverInfo() {
        this.serialVersionUID = 1L;
        this.imageUrl = "";
        this.streamUrl = "";
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public String getStreamUrl() {
        return this.streamUrl;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "GProRecommendCoverInfo{type=" + this.type + ",imageUrl=" + this.imageUrl + ",streamUrl=" + this.streamUrl + ",}";
    }

    public GProRecommendCoverInfo(int i2, String str, String str2) {
        this.serialVersionUID = 1L;
        this.imageUrl = "";
        this.streamUrl = "";
        this.type = i2;
        this.imageUrl = str;
        this.streamUrl = str2;
    }
}
