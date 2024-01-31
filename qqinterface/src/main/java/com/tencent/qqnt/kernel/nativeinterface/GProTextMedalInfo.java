package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProTextMedalInfo {
    int colorBg;
    int colorText;
    long expireTime;
    String name;

    public GProTextMedalInfo() {
        this.name = "";
    }

    public int getColorBg() {
        return this.colorBg;
    }

    public int getColorText() {
        return this.colorText;
    }

    public long getExpireTime() {
        return this.expireTime;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return "GProTextMedalInfo{name=" + this.name + ",expireTime=" + this.expireTime + ",colorText=" + this.colorText + ",colorBg=" + this.colorBg + ",}";
    }

    public GProTextMedalInfo(String str, long j2, int i2, int i3) {
        this.name = "";
        this.name = str;
        this.expireTime = j2;
        this.colorText = i2;
        this.colorBg = i3;
    }
}
