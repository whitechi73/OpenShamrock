package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProWorldState {
    long channelId;
    long guildId;
    byte[] roomChange;

    public GProWorldState() {
        this.roomChange = new byte[0];
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public byte[] getRoomChange() {
        return this.roomChange;
    }

    public String toString() {
        return "GProWorldState{guildId=" + this.guildId + ",channelId=" + this.channelId + ",roomChange=" + this.roomChange + ",}";
    }

    public GProWorldState(long j2, long j3, byte[] bArr) {
        this.roomChange = new byte[0];
        this.guildId = j2;
        this.channelId = j3;
        this.roomChange = bArr;
    }
}
