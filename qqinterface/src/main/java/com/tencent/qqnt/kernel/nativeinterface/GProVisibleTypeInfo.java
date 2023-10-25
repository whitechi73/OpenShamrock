package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProVisibleTypeInfo implements Serializable {
    long serialVersionUID;
    int visibleType;
    String visibleTypeText;

    public GProVisibleTypeInfo() {
        this.serialVersionUID = 1L;
        this.visibleTypeText = "";
    }

    public int getVisibleType() {
        return this.visibleType;
    }

    public String getVisibleTypeText() {
        return this.visibleTypeText;
    }

    public String toString() {
        return "GProVisibleTypeInfo{visibleType=" + this.visibleType + ",visibleTypeText=" + this.visibleTypeText + ",}";
    }

    public GProVisibleTypeInfo(int i2, String str) {
        this.serialVersionUID = 1L;
        this.visibleTypeText = "";
        this.visibleType = i2;
        this.visibleTypeText = str;
    }
}
