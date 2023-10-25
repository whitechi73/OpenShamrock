package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProBindRoleGroups {
    int authControlSwitchType;
    ArrayList<Long> roleGroupIds;

    public GProBindRoleGroups() {
        this.roleGroupIds = new ArrayList<>();
    }

    public int getAuthControlSwitchType() {
        return this.authControlSwitchType;
    }

    public ArrayList<Long> getRoleGroupIds() {
        return this.roleGroupIds;
    }

    public String toString() {
        return "GProBindRoleGroups{authControlSwitchType=" + this.authControlSwitchType + ",roleGroupIds=" + this.roleGroupIds + ",}";
    }

    public GProBindRoleGroups(int i2, ArrayList<Long> arrayList) {
        this.roleGroupIds = new ArrayList<>();
        this.authControlSwitchType = i2;
        this.roleGroupIds = arrayList;
    }
}
