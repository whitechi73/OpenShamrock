package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProDiscoverStatus {
    int nextTs;
    int state;
    int type;

    public GProDiscoverStatus() {
    }

    public int getNextTs() {
        return this.nextTs;
    }

    public int getState() {
        return this.state;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "GProDiscoverStatus{type=" + this.type + ",state=" + this.state + ",nextTs=" + this.nextTs + ",}";
    }

    public GProDiscoverStatus(int i2, int i3, int i4) {
        this.type = i2;
        this.state = i3;
        this.nextTs = i4;
    }
}
