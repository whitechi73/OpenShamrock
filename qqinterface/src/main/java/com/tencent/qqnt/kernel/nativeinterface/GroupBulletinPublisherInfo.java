package com.tencent.qqnt.kernel.nativeinterface;

public final class GroupBulletinPublisherInfo {
    String avatar;
    String nick;
    long uin;

    public GroupBulletinPublisherInfo() {
        this.nick = "";
        this.avatar = "";
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getNick() {
        return this.nick;
    }

    public long getUin() {
        return this.uin;
    }

    public String toString() {
        return "GroupBulletinPublisherInfo{uin=" + this.uin + ",nick=" + this.nick + ",avatar=" + this.avatar + ",}";
    }

    public GroupBulletinPublisherInfo(long j2, String str, String str2) {
        this.nick = "";
        this.avatar = "";
        this.uin = j2;
        this.nick = str;
        this.avatar = str2;
    }
}