package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProEncryptTextReq {
    String appId;
    String originalText;

    public GProEncryptTextReq() {
        this.appId = "";
        this.originalText = "";
    }

    public String getAppId() {
        return this.appId;
    }

    public String getOriginalText() {
        return this.originalText;
    }

    public String toString() {
        return "GProEncryptTextReq{appId=" + this.appId + ",originalText=" + this.originalText + ",}";
    }

    public GProEncryptTextReq(String str, String str2) {
        this.appId = "";
        this.originalText = "";
        this.appId = str;
        this.originalText = str2;
    }
}
