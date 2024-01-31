package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public  final class GProLinkDetailInfo implements Serializable {
    String longUrl;
    long serialVersionUID;

    public GProLinkDetailInfo() {
        this.serialVersionUID = 1L;
        this.longUrl = "";
    }

    public String getLongUrl() {
        return this.longUrl;
    }

    public String toString() {
        return "GProLinkDetailInfo{longUrl=" + this.longUrl + ",}";
    }

    public GProLinkDetailInfo(String str) {
        this.serialVersionUID = 1L;
        this.longUrl = "";
        this.longUrl = str;
    }
}
