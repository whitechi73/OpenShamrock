package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProURLParam {
    String key;
    String value;

    public GProURLParam() {
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
        return "GProURLParam{key=" + this.key + ",value=" + this.value + ",}";
    }

    public GProURLParam(String str, String str2) {
        this.key = "";
        this.value = "";
        this.key = str;
        this.value = str2;
    }
}
