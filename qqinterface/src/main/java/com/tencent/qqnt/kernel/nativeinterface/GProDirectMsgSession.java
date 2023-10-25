package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProDirectMsgSession {
    long channelId;
    int channelType;
    long guildId;
    int msgNotifyType;
    long msgTime;
    int peerMemberType;
    long srcGuildId;
    String srcGuildName;
    String srcMemberName;
    String srcNickName;
    long srcTinyId;

    public GProDirectMsgSession() {
        this.srcGuildName = "";
        this.srcMemberName = "";
        this.srcNickName = "";
    }

    public long getChannelId() {
        return this.channelId;
    }

    public int getChannelType() {
        return this.channelType;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public int getMsgNotifyType() {
        return this.msgNotifyType;
    }

    public long getMsgTime() {
        return this.msgTime;
    }

    public int getPeerMemberType() {
        return this.peerMemberType;
    }

    public long getSrcGuildId() {
        return this.srcGuildId;
    }

    public String getSrcGuildName() {
        return this.srcGuildName;
    }

    public String getSrcMemberName() {
        return this.srcMemberName;
    }

    public String getSrcNickName() {
        return this.srcNickName;
    }

    public long getSrcTinyId() {
        return this.srcTinyId;
    }

    public String toString() {
        return "GProDirectMsgSession{guildId=" + this.guildId + ",channelId=" + this.channelId + ",msgTime=" + this.msgTime + ",msgNotifyType=" + this.msgNotifyType + ",peerMemberType=" + this.peerMemberType + ",channelType=" + this.channelType + ",srcTinyId=" + this.srcTinyId + ",srcGuildId=" + this.srcGuildId + ",srcGuildName=" + this.srcGuildName + ",srcMemberName=" + this.srcMemberName + ",srcNickName=" + this.srcNickName + ",}";
    }

    public GProDirectMsgSession(long j2, long j3, long j4, int i2, int i3, int i4, long j5, long j6, String str, String str2, String str3) {
        this.srcGuildName = "";
        this.srcMemberName = "";
        this.srcNickName = "";
        this.guildId = j2;
        this.channelId = j3;
        this.msgTime = j4;
        this.msgNotifyType = i2;
        this.peerMemberType = i3;
        this.channelType = i4;
        this.srcTinyId = j5;
        this.srcGuildId = j6;
        this.srcGuildName = str;
        this.srcMemberName = str2;
        this.srcNickName = str3;
    }
}
