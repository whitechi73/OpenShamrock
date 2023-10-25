package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProAreaLevel {
    String desc;
    int level;

    public GProAreaLevel() {
        this.desc = "";
    }

    public String getDesc() {
        return this.desc;
    }

    public int getLevel() {
        return this.level;
    }

    public String toString() {
        return "GProAreaLevel{level=" + this.level + ",desc=" + this.desc + ",}";
    }

    public GProAreaLevel(int i2, String str) {
        this.desc = "";
        this.level = i2;
        this.desc = str;
    }
}
