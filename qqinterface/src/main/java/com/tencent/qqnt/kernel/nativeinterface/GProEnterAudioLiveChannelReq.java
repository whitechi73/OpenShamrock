package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProEnterAudioLiveChannelReq {
    long channelId;
    int channelType;
    boolean forceTRTCSign;
    long guildId;
    String joinSourceType;
    int sourceType;

    public GProEnterAudioLiveChannelReq() {
        this.joinSourceType = "";
    }

    public long getChannelId() {
        return this.channelId;
    }

    public int getChannelType() {
        return this.channelType;
    }

    public boolean getForceTRTCSign() {
        return this.forceTRTCSign;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getJoinSourceType() {
        return this.joinSourceType;
    }

    public int getSourceType() {
        return this.sourceType;
    }

    public String toString() {
        return "GProEnterAudioLiveChannelReq{guildId=" + this.guildId + ",channelId=" + this.channelId + ",sourceType=" + this.sourceType + ",forceTRTCSign=" + this.forceTRTCSign + ",joinSourceType=" + this.joinSourceType + ",channelType=" + this.channelType + ",}";
    }

    public GProEnterAudioLiveChannelReq(long j2, long j3, int i2, boolean z, String str, int i3) {
        this.joinSourceType = "";
        this.guildId = j2;
        this.channelId = j3;
        this.sourceType = i2;
        this.forceTRTCSign = z;
        this.joinSourceType = str;
        this.channelType = i3;
    }
}
