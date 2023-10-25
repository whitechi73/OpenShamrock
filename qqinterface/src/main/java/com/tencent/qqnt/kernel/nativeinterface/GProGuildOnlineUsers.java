package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProGuildOnlineUsers {
    long channelId;
    int channelType;
    String totalOnline;
    ArrayList<GProUser> users;

    public GProGuildOnlineUsers() {
        this.totalOnline = "";
        this.users = new ArrayList<>();
    }

    public long getChannelId() {
        return this.channelId;
    }

    public int getChannelType() {
        return this.channelType;
    }

    public String getTotalOnline() {
        return this.totalOnline;
    }

    public ArrayList<GProUser> getUsers() {
        return this.users;
    }

    public String toString() {
        return "GProGuildOnlineUsers{channelType=" + this.channelType + ",channelId=" + this.channelId + ",totalOnline=" + this.totalOnline + ",users=" + this.users + ",}";
    }

    public GProGuildOnlineUsers(int i2, long j2, String str, ArrayList<GProUser> arrayList) {
        this.totalOnline = "";
        this.users = new ArrayList<>();
        this.channelType = i2;
        this.channelId = j2;
        this.totalOnline = str;
        this.users = arrayList;
    }
}
