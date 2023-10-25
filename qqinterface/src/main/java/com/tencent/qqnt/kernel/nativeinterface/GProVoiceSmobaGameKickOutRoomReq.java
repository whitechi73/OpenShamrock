package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProVoiceSmobaGameKickOutRoomReq {
    long channelId;
    int forceExit;
    long guildId;
    long roomId;
    long second;
    long tinyId;

    public GProVoiceSmobaGameKickOutRoomReq() {
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

    public long getSecond() {
        return this.second;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public String toString() {
        return "GProVoiceSmobaGameKickOutRoomReq{tinyId=" + this.tinyId + ",roomId=" + this.roomId + ",guildId=" + this.guildId + ",channelId=" + this.channelId + ",forceExit=" + this.forceExit + ",second=" + this.second + ",}";
    }

    public GProVoiceSmobaGameKickOutRoomReq(long j2, long j3, long j4, long j5, int i2, long j6) {
        this.tinyId = j2;
        this.roomId = j3;
        this.guildId = j4;
        this.channelId = j5;
        this.forceExit = i2;
        this.second = j6;
    }
}
