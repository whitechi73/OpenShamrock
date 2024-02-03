package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProRoleCreateInfo {
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

    public GProRoleCreateInfo(String name, long color, boolean hoist, GProRolePermission permissions) {
        this.name = "";
        this.rolePermissions = new GProRolePermission();
    }
}
