package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProGuildJoin {
    String avatar;
    long guildId;
    int isMember;
    String joinSig;
    String name;
    long userId;
    int userType;

    public GProGuildJoin() {
        this.name = "";
        this.avatar = "";
        this.joinSig = "";
    }

    public String getAvatar() {
        return this.avatar;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public int getIsMember() {
        return this.isMember;
    }

    public String getJoinSig() {
        return this.joinSig;
    }

    public String getName() {
        return this.name;
    }

    public long getUserId() {
        return this.userId;
    }

    public int getUserType() {
        return this.userType;
    }

    public String toString() {
        return "GProGuildJoin{guildId=" + this.guildId + ",name=" + this.name + ",avatar=" + this.avatar + ",joinSig=" + this.joinSig + ",userId=" + this.userId + ",userType=" + this.userType + ",isMember=" + this.isMember + ",}";
    }

    public GProGuildJoin(long j2, String str, String str2, String str3, long j3, int i2, int i3) {
        this.name = "";
        this.avatar = "";
        this.joinSig = "";
        this.guildId = j2;
        this.name = str;
        this.avatar = str2;
        this.joinSig = str3;
        this.userId = j3;
        this.userType = i2;
        this.isMember = i3;
    }
}
