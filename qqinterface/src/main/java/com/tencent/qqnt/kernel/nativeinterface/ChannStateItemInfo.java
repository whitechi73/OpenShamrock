package com.tencent.qqnt.kernel.nativeinterface;

public final class ChannStateItemInfo {
    int channelState;
    String channelStateStr;
    int priority;
    long updateTs;

    public ChannStateItemInfo() {
        this.channelStateStr = "";
    }

    public int getChannelState() {
        return this.channelState;
    }

    public String getChannelStateStr() {
        return this.channelStateStr;
    }

    public int getPriority() {
        return this.priority;
    }

    public long getUpdateTs() {
        return this.updateTs;
    }

    public String toString() {
        return "ChannStateItemInfo{channelState=" + this.channelState + ",priority=" + this.priority + ",updateTs=" + this.updateTs + ",channelStateStr=" + this.channelStateStr + ",}";
    }

    public ChannStateItemInfo(int i2, int i3, long j2, String str) {
        this.channelStateStr = "";
        this.channelState = i2;
        this.priority = i3;
        this.updateTs = j2;
        this.channelStateStr = str;
    }
}