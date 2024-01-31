package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProVoiceSmobaGameBaseRoomParams {
    long channelId;
    long guildId;
    int roomType;

    public GProVoiceSmobaGameBaseRoomParams() {
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public int getRoomType() {
        return this.roomType;
    }

    public String toString() {
        return "GProVoiceSmobaGameBaseRoomParams{roomType=" + this.roomType + ",guildId=" + this.guildId + ",channelId=" + this.channelId + ",}";
    }

    public GProVoiceSmobaGameBaseRoomParams(int i2, long j2, long j3) {
        this.roomType = i2;
        this.guildId = j2;
        this.channelId = j3;
    }
}
