package com.tencent.qqnt.kernel.nativeinterface;



/* loaded from: classes2.dex */
public final class GProNoticeCover {
    long linkId;
    int type;
    String url;

    public GProNoticeCover() {
        this.url = "";
    }

    public long getLinkId() {
        return this.linkId;
    }

    public int getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "GProNoticeCover{type=" + this.type + ",linkId=" + this.linkId + ",url = " + this.url + ",}";
    }

    public GProNoticeCover(int i2, long j2, String str) {
        this.url = "";
        this.type = i2;
        this.linkId = j2;
        this.url = str;
    }
}
