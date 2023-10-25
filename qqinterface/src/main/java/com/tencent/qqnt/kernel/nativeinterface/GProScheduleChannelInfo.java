package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProScheduleChannelInfo {
    long channelId;
    String channelName;
    long guildId;
    boolean hasJoin;
    boolean isPrivate;
    int type;

    public GProScheduleChannelInfo() {
        this.channelName = "";
    }

    public long getChannelId() {
        return this.channelId;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public boolean getHasJoin() {
        return this.hasJoin;
    }

    public boolean getIsPrivate() {
        return this.isPrivate;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "GProScheduleChannelInfo{channelId=" + this.channelId + ",type=" + this.type + ",guildId=" + this.guildId + ",channelName=" + this.channelName + ",isPrivate=" + this.isPrivate + ",hasJoin=" + this.hasJoin + ",}";
    }

    public GProScheduleChannelInfo(long j2, int i2, long j3, String str, boolean z, boolean z2) {
        this.channelName = "";
        this.channelId = j2;
        this.type = i2;
        this.guildId = j3;
        this.channelName = str;
        this.isPrivate = z;
        this.hasJoin = z2;
    }
}
