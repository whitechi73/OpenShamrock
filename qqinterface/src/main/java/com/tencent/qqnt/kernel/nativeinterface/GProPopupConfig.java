package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProPopupConfig {
    String picUrl;
    String wording1;
    String wording2;

    public GProPopupConfig() {
        this.wording1 = "";
        this.wording2 = "";
        this.picUrl = "";
    }

    public String getPicUrl() {
        return this.picUrl;
    }

    public String getWording1() {
        return this.wording1;
    }

    public String getWording2() {
        return this.wording2;
    }

    public String toString() {
        return "GProPopupConfig{wording1=" + this.wording1 + ",wording2=" + this.wording2 + ",picUrl=" + this.picUrl + ",}";
    }

    public GProPopupConfig(String str, String str2, String str3) {
        this.wording1 = "";
        this.wording2 = "";
        this.picUrl = "";
        this.wording1 = str;
        this.wording2 = str2;
        this.picUrl = str3;
    }
}
