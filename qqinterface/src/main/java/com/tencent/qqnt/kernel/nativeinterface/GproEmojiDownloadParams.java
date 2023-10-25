package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GproEmojiDownloadParams {
    String md5;
    String resId;
    String url;

    public GproEmojiDownloadParams() {
        this.url = "";
        this.resId = "";
        this.md5 = "";
    }

    public String getMd5() {
        return this.md5;
    }

    public String getResId() {
        return this.resId;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "GproEmojiDownloadParams{url=" + this.url + ",resId=" + this.resId + ",md5=" + this.md5 + ",}";
    }

    public GproEmojiDownloadParams(String str, String str2, String str3) {
        this.url = "";
        this.resId = "";
        this.md5 = "";
        this.url = str;
        this.resId = str2;
        this.md5 = str3;
    }
}
