package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProUserChannelState {
    long channelId;
    long guildId;
    int platform;
    long tinyId;
    int userState;
    long userStateSeq;

    public GProUserChannelState() {
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public int getPlatform() {
        return this.platform;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public int getUserState() {
        return this.userState;
    }

    public long getUserStateSeq() {
        return this.userStateSeq;
    }

    public String toString() {
        return "GProUserChannelState{tinyId=" + this.tinyId + ",guildId=" + this.guildId + ",channelId=" + this.channelId + ",userStateSeq=" + this.userStateSeq + ",userState=" + this.userState + ",platform=" + this.platform + ",}";
    }

    public GProUserChannelState(long j2, long j3, long j4, long j5, int i2, int i3) {
        this.tinyId = j2;
        this.guildId = j3;
        this.channelId = j4;
        this.userStateSeq = j5;
        this.userState = i2;
        this.platform = i3;
    }
}
