package com.tencent.qqnt.kernel.nativeinterface;



public  final class GProBotClientInfo {
    int buildNum;
    int platform;
    String version;

    public GProBotClientInfo() {
        this.version = "";
    }

    public int getBuildNum() {
        return this.buildNum;
    }

    public int getPlatform() {
        return this.platform;
    }

    public String getVersion() {
        return this.version;
    }

    public String toString() {
        return "GProBotClientInfo{platform=" + this.platform + ",version = " + this.version + ",buildNum=" + this.buildNum + ",}";
    }

    public GProBotClientInfo(int i2, String str, int i3) {
        this.version = "";
        this.platform = i2;
        this.version = str;
        this.buildNum = i3;
    }
}
