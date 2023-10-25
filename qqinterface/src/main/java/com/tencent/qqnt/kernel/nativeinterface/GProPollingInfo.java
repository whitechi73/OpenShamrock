package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProPollingInfo {
    long channelId;
    long guildId;
    int pollingType;
    int source;

    public GProPollingInfo() {
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public int getPollingType() {
        return this.pollingType;
    }

    public int getSource() {
        return this.source;
    }

    public String toString() {
        return "GProPollingInfo{guildId=" + this.guildId + ",channelId=" + this.channelId + ",pollingType=" + this.pollingType + ",source=" + this.source + ",}";
    }

    public GProPollingInfo(long j2, long j3, int i2, int i3) {
        this.guildId = j2;
        this.channelId = j3;
        this.pollingType = i2;
        this.source = i3;
    }
}
