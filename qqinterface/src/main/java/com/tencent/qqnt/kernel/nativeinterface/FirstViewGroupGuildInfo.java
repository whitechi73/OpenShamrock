package com.tencent.qqnt.kernel.nativeinterface;


public  final class FirstViewGroupGuildInfo {
    int groupGuildSwitch;
    String groupId;
    String guildId;

    public FirstViewGroupGuildInfo() {
        this.groupId = "";
        this.guildId = "";
    }

    public int getGroupGuildSwitch() {
        return this.groupGuildSwitch;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public String getGuildId() {
        return this.guildId;
    }

    public String toString() {
        return "FirstViewGroupGuildInfo{groupId=" + this.groupId + ",guildId=" + this.guildId + ",groupGuildSwitch=" + this.groupGuildSwitch + ",}";
    }

    public FirstViewGroupGuildInfo(String str, String str2, int i2) {
        this.groupId = "";
        this.guildId = "";
        this.groupId = str;
        this.guildId = str2;
        this.groupGuildSwitch = i2;
    }
}
