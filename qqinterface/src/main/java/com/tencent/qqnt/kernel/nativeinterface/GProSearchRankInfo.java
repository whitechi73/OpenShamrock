package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProSearchRankInfo {
    String iconUrl;
    String text;

    public GProSearchRankInfo() {
        this.iconUrl = "";
        this.text = "";
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getText() {
        return this.text;
    }

    public String toString() {
        return "GProSearchRankInfo{iconUrl=" + this.iconUrl + ",text=" + this.text + ",}";
    }

    public GProSearchRankInfo(String str, String str2) {
        this.iconUrl = "";
        this.text = "";
        this.iconUrl = str;
        this.text = str2;
    }
}
