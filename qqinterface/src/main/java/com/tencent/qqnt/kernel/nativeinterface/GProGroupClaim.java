package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProGroupClaim implements Serializable {
    int groupType;
    int number;
    long serialVersionUID = 1;

    public GProGroupClaim() {
    }

    public int getGroupType() {
        return this.groupType;
    }

    public int getNumber() {
        return this.number;
    }

    public String toString() {
        return "GProGroupClaim{groupType=" + this.groupType + ",number=" + this.number + ",}";
    }

    public GProGroupClaim(int i2, int i3) {
        this.groupType = i2;
        this.number = i3;
    }
}
