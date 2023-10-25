package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProRolePermission {
    boolean hasRolePermission;
    ArrayList<GProPermissionInfo> permissionList;

    public GProRolePermission() {
        this.permissionList = new ArrayList<>();
    }

    public boolean getHasRolePermission() {
        return this.hasRolePermission;
    }

    public ArrayList<GProPermissionInfo> getPermissionList() {
        return this.permissionList;
    }

    public String toString() {
        return "GProRolePermission{hasRolePermission=" + this.hasRolePermission + ",permissionList=" + this.permissionList + ",}";
    }

    public GProRolePermission(boolean z, ArrayList<GProPermissionInfo> arrayList) {
        this.permissionList = new ArrayList<>();
        this.hasRolePermission = z;
        this.permissionList = arrayList;
    }
}
