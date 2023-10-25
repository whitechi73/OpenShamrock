package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProMsgGuildRole {
    boolean bHoist;
    long color;
    long guildId;
    String name;
    long roleId;
    long tinyId;

    public GProMsgGuildRole() {
        this.name = "";
    }

    public boolean getBHoist() {
        return this.bHoist;
    }

    public long getColor() {
        return this.color;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getName() {
        return this.name;
    }

    public long getRoleId() {
        return this.roleId;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public String toString() {
        return "GProMsgGuildRole{guildId=" + this.guildId + ",tinyId=" + this.tinyId + ",roleId=" + this.roleId + ",name=" + this.name + ",color=" + this.color + ",bHoist=" + this.bHoist + ",}";
    }

    public GProMsgGuildRole(long j2, long j3, long j4, String str, long j5, boolean z) {
        this.name = "";
        this.guildId = j2;
        this.tinyId = j3;
        this.roleId = j4;
        this.name = str;
        this.color = j5;
        this.bHoist = z;
    }
}
