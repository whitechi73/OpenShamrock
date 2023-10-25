package com.tencent.qqnt.kernel.nativeinterface;



import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProGameDownloadLink implements Serializable {
    String platform;
    long serialVersionUID;
    String url;

    public GProGameDownloadLink() {
        this.serialVersionUID = 1L;
        this.platform = "";
        this.url = "";
    }

    public String getPlatform() {
        return this.platform;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "GProGameDownloadLink{platform=" + this.platform + ",url = " + this.url + ",}";
    }

    public GProGameDownloadLink(String str, String str2) {
        this.serialVersionUID = 1L;
        this.platform = "";
        this.url = "";
        this.platform = str;
        this.url = str2;
    }
}
