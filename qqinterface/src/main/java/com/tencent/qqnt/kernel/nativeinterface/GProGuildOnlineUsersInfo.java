package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public  final class GProGuildOnlineUsersInfo {
    int groupType;
    ArrayList<GProGuildOnlineUsers> groupUsers;
    long guildId;
    long nextReadInterval;

    public GProGuildOnlineUsersInfo() {
        this.groupUsers = new ArrayList<>();
    }

    public int getGroupType() {
        return this.groupType;
    }

    public ArrayList<GProGuildOnlineUsers> getGroupUsers() {
        return this.groupUsers;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public long getNextReadInterval() {
        return this.nextReadInterval;
    }

    public String toString() {
        return "GProGuildOnlineUsersInfo{guildId=" + this.guildId + ",groupType=" + this.groupType + ",nextReadInterval=" + this.nextReadInterval + ",groupUsers=" + this.groupUsers + ",}";
    }

    public GProGuildOnlineUsersInfo(long j2, int i2, long j3, ArrayList<GProGuildOnlineUsers> arrayList) {
        this.groupUsers = new ArrayList<>();
        this.guildId = j2;
        this.groupType = i2;
        this.nextReadInterval = j3;
        this.groupUsers = arrayList;
    }
}
