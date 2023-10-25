package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProMsgRouttingHead {
    long channelId;
    int directMsgFlag;
    long fromTinyid;
    long fromUin;
    long guildCode;
    long guildId;

    public GProMsgRouttingHead() {
    }

    public long getChannelId() {
        return this.channelId;
    }

    public int getDirectMsgFlag() {
        return this.directMsgFlag;
    }

    public long getFromTinyid() {
        return this.fromTinyid;
    }

    public long getFromUin() {
        return this.fromUin;
    }

    public long getGuildCode() {
        return this.guildCode;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String toString() {
        return "GProMsgRouttingHead{guildId=" + this.guildId + ",channelId=" + this.channelId + ",fromUin=" + this.fromUin + ",fromTinyid=" + this.fromTinyid + ",guildCode=" + this.guildCode + ",directMsgFlag=" + this.directMsgFlag + ",}";
    }

    public GProMsgRouttingHead(long j2, long j3, long j4, long j5, long j6, int i2) {
        this.guildId = j2;
        this.channelId = j3;
        this.fromUin = j4;
        this.fromTinyid = j5;
        this.guildCode = j6;
        this.directMsgFlag = i2;
    }
}
