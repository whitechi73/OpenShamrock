package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProDirectMsgDetailSession {
    long channelId;
    long createTime;
    long guildId;
    long lastCntSeq;
    long lastCntTime;
    long lastMsgSeq;
    long lastMsgTime;
    long msgEventTime;
    int msgNotifyType;
    long myReadCntSeq;
    long myReadCntTime;
    long myReadMsgSeq;
    long myReadMsgTime;
    long srcGuildId;
    String srcGuildName;
    String srcMemberName;
    int srcMemberType;
    String srcNickName;
    long srcTinyId;

    public GProDirectMsgDetailSession() {
        this.srcGuildName = "";
        this.srcMemberName = "";
        this.srcNickName = "";
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public long getLastCntSeq() {
        return this.lastCntSeq;
    }

    public long getLastCntTime() {
        return this.lastCntTime;
    }

    public long getLastMsgSeq() {
        return this.lastMsgSeq;
    }

    public long getLastMsgTime() {
        return this.lastMsgTime;
    }

    public long getMsgEventTime() {
        return this.msgEventTime;
    }

    public int getMsgNotifyType() {
        return this.msgNotifyType;
    }

    public long getMyReadCntSeq() {
        return this.myReadCntSeq;
    }

    public long getMyReadCntTime() {
        return this.myReadCntTime;
    }

    public long getMyReadMsgSeq() {
        return this.myReadMsgSeq;
    }

    public long getMyReadMsgTime() {
        return this.myReadMsgTime;
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

    public int getSrcMemberType() {
        return this.srcMemberType;
    }

    public String getSrcNickName() {
        return this.srcNickName;
    }

    public long getSrcTinyId() {
        return this.srcTinyId;
    }

    public String toString() {
        return "GProDirectMsgDetailSession{guildId=" + this.guildId + ",channelId=" + this.channelId + ",msgNotifyType=" + this.msgNotifyType + ",myReadMsgSeq=" + this.myReadMsgSeq + ",myReadMsgTime=" + this.myReadMsgTime + ",myReadCntSeq=" + this.myReadCntSeq + ",myReadCntTime=" + this.myReadCntTime + ",lastMsgSeq=" + this.lastMsgSeq + ",lastMsgTime=" + this.lastMsgTime + ",lastCntSeq=" + this.lastCntSeq + ",lastCntTime=" + this.lastCntTime + ",srcTinyId=" + this.srcTinyId + ",srcGuildId=" + this.srcGuildId + ",srcGuildName=" + this.srcGuildName + ",srcMemberName=" + this.srcMemberName + ",srcNickName=" + this.srcNickName + ",srcMemberType=" + this.srcMemberType + ",msgEventTime=" + this.msgEventTime + ",createTime=" + this.createTime + ",}";
    }

    public GProDirectMsgDetailSession(long j2, long j3, int i2, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, String str, String str2, String str3, int i3, long j14, long j15) {
        this.srcGuildName = "";
        this.srcMemberName = "";
        this.srcNickName = "";
        this.guildId = j2;
        this.channelId = j3;
        this.msgNotifyType = i2;
        this.myReadMsgSeq = j4;
        this.myReadMsgTime = j5;
        this.myReadCntSeq = j6;
        this.myReadCntTime = j7;
        this.lastMsgSeq = j8;
        this.lastMsgTime = j9;
        this.lastCntSeq = j10;
        this.lastCntTime = j11;
        this.srcTinyId = j12;
        this.srcGuildId = j13;
        this.srcGuildName = str;
        this.srcMemberName = str2;
        this.srcNickName = str3;
        this.srcMemberType = i3;
        this.msgEventTime = j14;
        this.createTime = j15;
    }
}
