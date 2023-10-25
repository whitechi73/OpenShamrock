package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProUserListGroupInfo implements Serializable {
    int groupType;
    long serialVersionUID = 1;

    public GProUserListGroupInfo() {
    }

    public int getGroupType() {
        return this.groupType;
    }

    public String toString() {
        return "GProUserListGroupInfo{groupType=" + this.groupType + ",}";
    }

    public GProUserListGroupInfo(int i2) {
        this.groupType = i2;
    }
}
