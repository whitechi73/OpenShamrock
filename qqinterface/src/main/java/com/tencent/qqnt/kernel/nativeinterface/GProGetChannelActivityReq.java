package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProGetChannelActivityReq {
    int channelType;
    long guildId;

    public GProGetChannelActivityReq() {
    }

    public int getChannelType() {
        return this.channelType;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String toString() {
        return "GProGetChannelActivityReq{guildId=" + this.guildId + ",channelType=" + this.channelType + ",}";
    }

    public GProGetChannelActivityReq(long j2, int i2) {
        this.guildId = j2;
        this.channelType = i2;
    }
}
