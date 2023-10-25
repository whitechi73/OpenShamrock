package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProSearchUser {
    String avatar;
    String nick;
    long tinyId;

    public GProSearchUser() {
        this.nick = "";
        this.avatar = "";
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getNick() {
        return this.nick;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public String toString() {
        return "GProSearchUser{nick=" + this.nick + ",tinyId=" + this.tinyId + ",avatar=" + this.avatar + ",}";
    }

    public GProSearchUser(String str, long j2, String str2) {
        this.nick = "";
        this.avatar = "";
        this.nick = str;
        this.tinyId = j2;
        this.avatar = str2;
    }
}
