package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProMetricsItem {
    String name;
    long num;
    int type;

    public GProMetricsItem() {
        this.name = "";
    }

    public String getName() {
        return this.name;
    }

    public long getNum() {
        return this.num;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "GProMetricsItem{type=" + this.type + ",name=" + this.name + ",num=" + this.num + ",}";
    }

    public GProMetricsItem(int i2, String str, long j2) {
        this.name = "";
        this.type = i2;
        this.name = str;
        this.num = j2;
    }
}
