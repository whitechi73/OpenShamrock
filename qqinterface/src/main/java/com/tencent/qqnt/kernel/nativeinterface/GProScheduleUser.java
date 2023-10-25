package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProScheduleUser {
    String avatar;
    String nick;
    int role;
    long tinyId;

    public GProScheduleUser() {
        this.nick = "";
        this.avatar = "";
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getNick() {
        return this.nick;
    }

    public int getRole() {
        return this.role;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public String toString() {
        return "GProScheduleUser{nick=" + this.nick + ",tinyId=" + this.tinyId + ",avatar=" + this.avatar + ",role=" + this.role + ",}";
    }

    public GProScheduleUser(String str, long j2, String str2, int i2) {
        this.nick = "";
        this.avatar = "";
        this.nick = str;
        this.tinyId = j2;
        this.avatar = str2;
        this.role = i2;
    }
}
