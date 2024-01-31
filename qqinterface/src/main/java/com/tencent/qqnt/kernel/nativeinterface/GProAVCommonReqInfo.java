package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProAVCommonReqInfo {
    long appId;
    long channelId;
    long guildId;

    public GProAVCommonReqInfo() {
    }

    public long getAppId() {
        return this.appId;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String toString() {
        return "GProAVCommonReqInfo{guildId=" + this.guildId + ",channelId=" + this.channelId + ",appId=" + this.appId + ",}";
    }

    public GProAVCommonReqInfo(long j2, long j3, long j4) {
        this.guildId = j2;
        this.channelId = j3;
        this.appId = j4;
    }
}
