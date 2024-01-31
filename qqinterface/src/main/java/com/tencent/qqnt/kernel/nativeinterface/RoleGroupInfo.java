package com.tencent.qqnt.kernel.nativeinterface;


public  final class RoleGroupInfo {
    int color;
    String name;
    long roleId;

    public RoleGroupInfo() {
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
        return "RoleGroupInfo{roleId=" + this.roleId + ",name=" + this.name + ",color=" + this.color + ",}";
    }

    public RoleGroupInfo(long j2, String str, int i2) {
        this.name = "";
        this.roleId = j2;
        this.name = str;
        this.color = i2;
    }
}
