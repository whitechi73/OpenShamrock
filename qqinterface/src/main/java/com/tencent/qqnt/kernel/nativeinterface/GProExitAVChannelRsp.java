package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProExitAVChannelRsp {
    long channelId;
    long guildId;

    public GProExitAVChannelRsp() {
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String toString() {
        return "GProExitAVChannelRsp{guildId=" + this.guildId + ",channelId=" + this.channelId + ",}";
    }

    public GProExitAVChannelRsp(long j2, long j3) {
        this.guildId = j2;
        this.channelId = j3;
    }
}
