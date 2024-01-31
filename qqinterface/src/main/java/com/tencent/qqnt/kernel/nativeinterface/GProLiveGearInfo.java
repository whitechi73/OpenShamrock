package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProLiveGearInfo {
    Integer bitRate;
    Integer level;
    String name;
    Integer pixelsX;
    Integer pixelsY;

    public GProLiveGearInfo() {
    }

    public Integer getBitRate() {
        return this.bitRate;
    }

    public Integer getLevel() {
        return this.level;
    }

    public String getName() {
        return this.name;
    }

    public Integer getPixelsX() {
        return this.pixelsX;
    }

    public Integer getPixelsY() {
        return this.pixelsY;
    }

    public String toString() {
        return "GProLiveGearInfo{level=" + this.level + ",bitRate=" + this.bitRate + ",name=" + this.name + ",pixelsX=" + this.pixelsX + ",pixelsY=" + this.pixelsY + ",}";
    }

    public GProLiveGearInfo(Integer num, Integer num2, String str, Integer num3, Integer num4) {
        this.level = num;
        this.bitRate = num2;
        this.name = str;
        this.pixelsX = num3;
        this.pixelsY = num4;
    }
}
