package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProGuildUserState {
    long channelId;
    long guildId;
    boolean hasEnteredChannel;

    public GProGuildUserState() {
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public boolean getHasEnteredChannel() {
        return this.hasEnteredChannel;
    }

    public String toString() {
        return "GProGuildUserState{guildId=" + this.guildId + ",channelId=" + this.channelId + ",hasEnteredChannel=" + this.hasEnteredChannel + ",}";
    }

    public GProGuildUserState(long j2, long j3, boolean z) {
        this.guildId = j2;
        this.channelId = j3;
        this.hasEnteredChannel = z;
    }
}
