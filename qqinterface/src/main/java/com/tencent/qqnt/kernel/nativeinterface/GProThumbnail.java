package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProThumbnail {
    int type;
    String url;

    public GProThumbnail() {
        this.url = "";
    }

    public int getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "GProThumbnail{url=" + this.url + ",type=" + this.type + ",}";
    }

    public GProThumbnail(String str, int i2) {
        this.url = "";
        this.url = str;
        this.type = i2;
    }
}
