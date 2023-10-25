package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProQQMsgListChannel {
    long appid;
    long avatarSeq;
    long channelId;
    String channelName;
    int channelType;
    long guildId;
    String guildName;
    long topTimestamp;

    public GProQQMsgListChannel() {
        this.guildName = "";
        this.channelName = "";
    }

    public long getAppid() {
        return this.appid;
    }

    public long getAvatarSeq() {
        return this.avatarSeq;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public int getChannelType() {
        return this.channelType;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getGuildName() {
        return this.guildName;
    }

    public long getTopTimestamp() {
        return this.topTimestamp;
    }

    public String toString() {
        return "GProQQMsgListChannel{guildId=" + this.guildId + ",channelId=" + this.channelId + ",topTimestamp=" + this.topTimestamp + ",guildName=" + this.guildName + ",channelName=" + this.channelName + ",avatarSeq=" + this.avatarSeq + ",channelType=" + this.channelType + ",appid=" + this.appid + ",}";
    }

    public GProQQMsgListChannel(long j2, long j3, long j4, String str, String str2, long j5, int i2, long j6) {
        this.guildName = "";
        this.channelName = "";
        this.guildId = j2;
        this.channelId = j3;
        this.topTimestamp = j4;
        this.guildName = str;
        this.channelName = str2;
        this.avatarSeq = j5;
        this.channelType = i2;
        this.appid = j6;
    }
}
