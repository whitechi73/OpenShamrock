package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProGuildNumInfo {
    long leftTime;
    String name;
    int status;

    public GProGuildNumInfo() {
        this.name = "";
    }

    public long getLeftTime() {
        return this.leftTime;
    }

    public String getName() {
        return this.name;
    }

    public int getStatus() {
        return this.status;
    }

    public String toString() {
        return "GProGuildNumInfo{name=" + this.name + ",status=" + this.status + ",leftTime=" + this.leftTime + ",}";
    }

    public GProGuildNumInfo(String str, int i2, long j2) {
        this.name = "";
        this.name = str;
        this.status = i2;
        this.leftTime = j2;
    }
}
