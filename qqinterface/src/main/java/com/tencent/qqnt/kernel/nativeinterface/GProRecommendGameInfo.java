package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProRecommendGameInfo {
    String icon;
    int id;
    GProRecommendModeInfo modeInfo;
    String name;

    public GProRecommendGameInfo() {
        this.name = "";
        this.icon = "";
        this.modeInfo = new GProRecommendModeInfo();
    }

    public String getIcon() {
        return this.icon;
    }

    public int getId() {
        return this.id;
    }

    public GProRecommendModeInfo getModeInfo() {
        return this.modeInfo;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return "GProRecommendGameInfo{id=" + this.id + ",name=" + this.name + ",icon=" + this.icon + ",modeInfo=" + this.modeInfo + ",}";
    }

    public GProRecommendGameInfo(int i2, String str, String str2, GProRecommendModeInfo gProRecommendModeInfo) {
        this.name = "";
        this.icon = "";
        this.modeInfo = new GProRecommendModeInfo();
        this.id = i2;
        this.name = str;
        this.icon = str2;
        this.modeInfo = gProRecommendModeInfo;
    }
}
