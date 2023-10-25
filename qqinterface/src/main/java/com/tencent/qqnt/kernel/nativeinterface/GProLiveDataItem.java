package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProLiveDataItem {
    boolean isShow;
    String name;
    int type;
    long value;

    public GProLiveDataItem() {
        this.name = "";
    }

    public boolean getIsShow() {
        return this.isShow;
    }

    public String getName() {
        return this.name;
    }

    public int getType() {
        return this.type;
    }

    public long getValue() {
        return this.value;
    }

    public String toString() {
        return "GProLiveDataItem{type=" + this.type + ",name=" + this.name + ",value=" + this.value + ",isShow=" + this.isShow + ",}";
    }

    public GProLiveDataItem(int i2, String str, long j2, boolean z) {
        this.name = "";
        this.type = i2;
        this.name = str;
        this.value = j2;
        this.isShow = z;
    }
}
