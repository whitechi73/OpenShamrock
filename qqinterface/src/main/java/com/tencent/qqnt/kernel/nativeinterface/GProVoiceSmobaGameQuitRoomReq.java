package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProVoiceSmobaGameQuitRoomReq {
    long channelId;
    int forceExit;
    long guildId;
    long roomId;

    public GProVoiceSmobaGameQuitRoomReq() {
    }

    public long getChannelId() {
        return this.channelId;
    }

    public int getForceExit() {
        return this.forceExit;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public long getRoomId() {
        return this.roomId;
    }

    public String toString() {
        return "GProVoiceSmobaGameQuitRoomReq{roomId=" + this.roomId + ",guildId=" + this.guildId + ",channelId=" + this.channelId + ",forceExit=" + this.forceExit + ",}";
    }

    public GProVoiceSmobaGameQuitRoomReq(long j2, long j3, long j4, int i2) {
        this.roomId = j2;
        this.guildId = j3;
        this.channelId = j4;
        this.forceExit = i2;
    }
}
