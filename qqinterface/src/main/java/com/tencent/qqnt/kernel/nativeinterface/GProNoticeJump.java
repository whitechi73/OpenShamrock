package com.tencent.qqnt.kernel.nativeinterface;



/* loaded from: classes2.dex */
public final class GProNoticeJump {
    String iconUrl;
    int iconUrlIndex;
    int placeHolderIndex;
    String text;
    String url;

    public GProNoticeJump() {
        this.text = "";
        this.url = "";
        this.iconUrl = "";
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public int getIconUrlIndex() {
        return this.iconUrlIndex;
    }

    public int getPlaceHolderIndex() {
        return this.placeHolderIndex;
    }

    public String getText() {
        return this.text;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "GProNoticeJump{text=" + this.text + ",url = " + this.url + ",placeHolderIndex=" + this.placeHolderIndex + ",iconUrl=" + this.iconUrl + ",iconUrlIndex=" + this.iconUrlIndex + ",}";
    }

    public GProNoticeJump(String str, String str2, int i2, String str3, int i3) {
        this.text = "";
        this.url = "";
        this.iconUrl = "";
        this.text = str;
        this.url = str2;
        this.placeHolderIndex = i2;
        this.iconUrl = str3;
        this.iconUrlIndex = i3;
    }
}
