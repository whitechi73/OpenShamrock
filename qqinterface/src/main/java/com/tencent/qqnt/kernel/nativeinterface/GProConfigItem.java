package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProConfigItem {
    int configID;
    int configStatus;
    String desc;

    public GProConfigItem() {
        this.desc = "";
    }

    public int getConfigID() {
        return this.configID;
    }

    public int getConfigStatus() {
        return this.configStatus;
    }

    public String getDesc() {
        return this.desc;
    }

    public String toString() {
        return "GProConfigItem{configID=" + this.configID + ",configStatus=" + this.configStatus + ",desc=" + this.desc + ",}";
    }

    public GProConfigItem(int i2, int i3, String str) {
        this.desc = "";
        this.configID = i2;
        this.configStatus = i3;
        this.desc = str;
    }
}
