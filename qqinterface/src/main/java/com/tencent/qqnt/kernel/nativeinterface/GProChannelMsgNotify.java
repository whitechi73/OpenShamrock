package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProChannelMsgNotify {
    long channelId;
    int msgNotifyType;

    public GProChannelMsgNotify() {
    }

    public long getChannelId() {
        return this.channelId;
    }

    public int getMsgNotifyType() {
        return this.msgNotifyType;
    }

    public String toString() {
        return "GProChannelMsgNotify{channelId=" + this.channelId + ",msgNotifyType=" + this.msgNotifyType + ",}";
    }

    public GProChannelMsgNotify(long j2, int i2) {
        this.channelId = j2;
        this.msgNotifyType = i2;
    }
}
