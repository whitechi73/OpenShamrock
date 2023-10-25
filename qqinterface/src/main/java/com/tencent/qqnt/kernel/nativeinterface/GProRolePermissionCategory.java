package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProRolePermissionCategory {
    String name;
    int packCount;

    public GProRolePermissionCategory() {
        this.name = "";
    }

    public String getName() {
        return this.name;
    }

    public int getPackCount() {
        return this.packCount;
    }

    public String toString() {
        return "GProRolePermissionCategory{name=" + this.name + ",packCount=" + this.packCount + ",}";
    }

    public GProRolePermissionCategory(String str, int i2) {
        this.name = "";
        this.name = str;
        this.packCount = i2;
    }
}
