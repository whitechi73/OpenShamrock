package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProVoiceSmobaGameDissmissRoomReq {
    long channelId;
    long guildId;
    long roomId;
    int source;

    public GProVoiceSmobaGameDissmissRoomReq() {
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public long getRoomId() {
        return this.roomId;
    }

    public int getSource() {
        return this.source;
    }

    public String toString() {
        return "GProVoiceSmobaGameDissmissRoomReq{roomId=" + this.roomId + ",guildId=" + this.guildId + ",channelId=" + this.channelId + ",source=" + this.source + ",}";
    }

    public GProVoiceSmobaGameDissmissRoomReq(long j2, long j3, long j4, int i2) {
        this.roomId = j2;
        this.guildId = j3;
        this.channelId = j4;
        this.source = i2;
    }
}
