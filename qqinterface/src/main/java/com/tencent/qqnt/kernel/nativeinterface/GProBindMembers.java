package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProBindMembers {
    int authControlSwitchType;
    ArrayList<Long> memberIds;

    public GProBindMembers() {
        this.memberIds = new ArrayList<>();
    }

    public int getAuthControlSwitchType() {
        return this.authControlSwitchType;
    }

    public ArrayList<Long> getMemberIds() {
        return this.memberIds;
    }

    public String toString() {
        return "GProBindMembers{authControlSwitchType=" + this.authControlSwitchType + ",memberIds=" + this.memberIds + ",}";
    }

    public GProBindMembers(int i2, ArrayList<Long> arrayList) {
        this.memberIds = new ArrayList<>();
        this.authControlSwitchType = i2;
        this.memberIds = arrayList;
    }
}
