package com.tencent.qqnt.kernel.nativeinterface;


public  final class FromRoleInfo {
    int color;
    String name;
    long roleId;

    public FromRoleInfo() {
        this.name = "";
    }

    public int getColor() {
        return this.color;
    }

    public String getName() {
        return this.name;
    }

    public long getRoleId() {
        return this.roleId;
    }

    public String toString() {
        return "FromRoleInfo{roleId=" + this.roleId + ",name=" + this.name + ",color=" + this.color + ",}";
    }

    public FromRoleInfo(long j2, String str, int i2) {
        this.name = "";
        this.roleId = j2;
        this.name = str;
        this.color = i2;
    }
}
