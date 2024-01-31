package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProVoiceSmobaGameBaseRoomInfo {
    long captainTinyId;
    long channelId;
    long guildId;
    long roomId;
    int roomType;

    public GProVoiceSmobaGameBaseRoomInfo() {
    }

    public long getCaptainTinyId() {
        return this.captainTinyId;
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

    public int getRoomType() {
        return this.roomType;
    }

    public String toString() {
        return "GProVoiceSmobaGameBaseRoomInfo{roomId=" + this.roomId + ",roomType=" + this.roomType + ",guildId=" + this.guildId + ",channelId=" + this.channelId + ",captainTinyId=" + this.captainTinyId + ",}";
    }

    public GProVoiceSmobaGameBaseRoomInfo(long j2, int i2, long j3, long j4, long j5) {
        this.roomId = j2;
        this.roomType = i2;
        this.guildId = j3;
        this.channelId = j4;
        this.captainTinyId = j5;
    }
}
