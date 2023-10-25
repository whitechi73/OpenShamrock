package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProScheduleSendArkGuildInfo {
    long channelId;
    long guildId;

    public GProScheduleSendArkGuildInfo() {
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String toString() {
        return "GProScheduleSendArkGuildInfo{guildId=" + this.guildId + ",channelId=" + this.channelId + ",}";
    }

    public GProScheduleSendArkGuildInfo(long j2, long j3) {
        this.guildId = j2;
        this.channelId = j3;
    }
}
