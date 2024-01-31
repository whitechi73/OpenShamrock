package com.tencent.qqnt.kernel.nativeinterface;


public  final class IconInfo {
    String iconUrl;
    String iconUrl100;
    String iconUrl140;
    String iconUrl40;
    String iconUrl640;

    public IconInfo() {
        this.iconUrl = "";
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getIconUrl100() {
        return this.iconUrl100;
    }

    public String getIconUrl140() {
        return this.iconUrl140;
    }

    public String getIconUrl40() {
        return this.iconUrl40;
    }

    public String getIconUrl640() {
        return this.iconUrl640;
    }

    public String toString() {
        return "IconInfo{iconUrl40=" + this.iconUrl40 + ",iconUrl100=" + this.iconUrl100 + ",iconUrl140=" + this.iconUrl140 + ",iconUrl640=" + this.iconUrl640 + ",iconUrl=" + this.iconUrl + ",}";
    }

    public IconInfo(String str, String str2, String str3, String str4, String str5) {
        this.iconUrl = "";
        this.iconUrl40 = str;
        this.iconUrl100 = str2;
        this.iconUrl140 = str3;
        this.iconUrl640 = str4;
        this.iconUrl = str5;
    }
}
