package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProGuildOnlineReportExtInfo {
    String key;
    String value;

    public GProGuildOnlineReportExtInfo() {
        this.key = "";
        this.value = "";
    }

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    public String toString() {
        return "GProGuildOnlineReportExtInfo{key=" + this.key + ",value=" + this.value + ",}";
    }

    public GProGuildOnlineReportExtInfo(String str, String str2) {
        this.key = "";
        this.value = "";
        this.key = str;
        this.value = str2;
    }
}
