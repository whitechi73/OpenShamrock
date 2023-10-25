package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProNoticeRedPoint {
    int count;
    int expireTs;
    int muteSwitch;
    int type;

    public GProNoticeRedPoint() {
    }

    public int getCount() {
        return this.count;
    }

    public int getExpireTs() {
        return this.expireTs;
    }

    public int getMuteSwitch() {
        return this.muteSwitch;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "GProNoticeRedPoint{type=" + this.type + ",count=" + this.count + ",expireTs=" + this.expireTs + ",muteSwitch=" + this.muteSwitch + ",}";
    }

    public GProNoticeRedPoint(int i2, int i3, int i4, int i5) {
        this.type = i2;
        this.count = i3;
        this.expireTs = i4;
        this.muteSwitch = i5;
    }
}
