package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProSeqCond {
    long beginSeq;
    long channelId;
    long endSeq;
    long guildId;

    public GProSeqCond() {
    }

    public long getBeginSeq() {
        return this.beginSeq;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getEndSeq() {
        return this.endSeq;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String toString() {
        return "GProSeqCond{guildId=" + this.guildId + ",channelId=" + this.channelId + ",beginSeq=" + this.beginSeq + ",endSeq=" + this.endSeq + ",}";
    }

    public GProSeqCond(long j2, long j3, long j4, long j5) {
        this.guildId = j2;
        this.channelId = j3;
        this.beginSeq = j4;
        this.endSeq = j5;
    }
}
