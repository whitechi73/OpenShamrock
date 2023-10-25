package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProGuildBottomTabExpData {
    long expId;
    String expIndex;
    boolean isHit;
    int tabType;

    public GProGuildBottomTabExpData() {
        this.expIndex = "";
    }

    public long getExpId() {
        return this.expId;
    }

    public String getExpIndex() {
        return this.expIndex;
    }

    public boolean getIsHit() {
        return this.isHit;
    }

    public int getTabType() {
        return this.tabType;
    }

    public String toString() {
        return "GProGuildBottomTabExpData{isHit=" + this.isHit + ",expId=" + this.expId + ",expIndex=" + this.expIndex + ",tabType=" + this.tabType + ",}";
    }

    public GProGuildBottomTabExpData(boolean z, long j2, String str, int i2) {
        this.expIndex = "";
        this.isHit = z;
        this.expId = j2;
        this.expIndex = str;
        this.tabType = i2;
    }
}
