package com.tencent.qqnt.kernel.nativeinterface;


public  final class LiveGiftMemberInfo {
    String nickName;
    int roleColor;
    long roleId;
    String roleName;
    String tinyId;

    public LiveGiftMemberInfo() {
        this.tinyId = "";
        this.nickName = "";
        this.roleName = "";
    }

    public String getNickName() {
        return this.nickName;
    }

    public int getRoleColor() {
        return this.roleColor;
    }

    public long getRoleId() {
        return this.roleId;
    }

    public String getRoleName() {
        return this.roleName;
    }

    public String getTinyId() {
        return this.tinyId;
    }

    public String toString() {
        return "LiveGiftMemberInfo{tinyId=" + this.tinyId + ",nickName=" + this.nickName + ",roleId=" + this.roleId + ",roleName=" + this.roleName + ",roleColor=" + this.roleColor + ",}";
    }

    public LiveGiftMemberInfo(String str, String str2, long j2, String str3, int i2) {
        this.tinyId = "";
        this.nickName = "";
        this.roleName = "";
        this.tinyId = str;
        this.nickName = str2;
        this.roleId = j2;
        this.roleName = str3;
        this.roleColor = i2;
    }
}
