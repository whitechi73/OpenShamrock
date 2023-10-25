package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProRoleCreateInfo {
    boolean bHoist;
    long color;
    String name;
    GProRolePermission rolePermissions;

    public GProRoleCreateInfo() {
        this.name = "";
        this.rolePermissions = new GProRolePermission();
    }

    public boolean getBHoist() {
        return this.bHoist;
    }

    public long getColor() {
        return this.color;
    }

    public String getName() {
        return this.name;
    }

    public GProRolePermission getRolePermissions() {
        return this.rolePermissions;
    }

    public String toString() {
        return "GProRoleCreateInfo{name=" + this.name + ",color=" + this.color + ",bHoist=" + this.bHoist + ",rolePermissions=" + this.rolePermissions + ",}";
    }

    public GProRoleCreateInfo(String str, long j2, boolean z, GProRolePermission gProRolePermission) {
        this.name = "";
        this.rolePermissions = new GProRolePermission();
        this.name = str;
        this.color = j2;
        this.bHoist = z;
        this.rolePermissions = gProRolePermission;
    }
}
