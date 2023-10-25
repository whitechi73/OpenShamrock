package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes4.dex */
public final class GProFDLEntry {
    String key;
    String value;

    public GProFDLEntry() {
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
        return "GProFDLEntry{key=" + this.key + ",value=" + this.value + ",}";
    }

    public GProFDLEntry(String str, String str2) {
        this.key = "";
        this.value = "";
        this.key = str;
        this.value = str2;
    }
}
