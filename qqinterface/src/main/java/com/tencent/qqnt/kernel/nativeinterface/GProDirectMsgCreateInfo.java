package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProDirectMsgCreateInfo {
    int channelType;
    int msgNotifyType;
    long msgTime;
    long srcGuildId;
    String srcGuildName;
    String srcMemberName;
    String srcNickName;
    long srcTinyId;

    public GProDirectMsgCreateInfo() {
        this.srcGuildName = "";
        this.srcMemberName = "";
        this.srcNickName = "";
    }

    public int getChannelType() {
        return this.channelType;
    }

    public int getMsgNotifyType() {
        return this.msgNotifyType;
    }

    public long getMsgTime() {
        return this.msgTime;
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
        return "GProDirectMsgCreateInfo{srcTinyId=" + this.srcTinyId + ",srcGuildId=" + this.srcGuildId + ",srcGuildName=" + this.srcGuildName + ",srcMemberName=" + this.srcMemberName + ",srcNickName=" + this.srcNickName + ",msgTime=" + this.msgTime + ",msgNotifyType=" + this.msgNotifyType + ",channelType=" + this.channelType + ",}";
    }

    public GProDirectMsgCreateInfo(long j2, long j3, String str, String str2, String str3, long j4, int i2, int i3) {
        this.srcGuildName = "";
        this.srcMemberName = "";
        this.srcNickName = "";
        this.srcTinyId = j2;
        this.srcGuildId = j3;
        this.srcGuildName = str;
        this.srcMemberName = str2;
        this.srcNickName = str3;
        this.msgTime = j4;
        this.msgNotifyType = i2;
        this.channelType = i3;
    }
}
