package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProGuildReqInfo {
    long channelChangeSeq;
    long guildChangeSeq;
    long guildId;

    public GProGuildReqInfo() {
    }

    public long getChannelChangeSeq() {
        return this.channelChangeSeq;
    }

    public long getGuildChangeSeq() {
        return this.guildChangeSeq;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String toString() {
        return "GProGuildReqInfo{guildId=" + this.guildId + ",guildChangeSeq=" + this.guildChangeSeq + ",channelChangeSeq=" + this.channelChangeSeq + ",}";
    }

    public GProGuildReqInfo(long j2, long j3, long j4) {
        this.guildId = j2;
        this.guildChangeSeq = j3;
        this.channelChangeSeq = j4;
    }
}
