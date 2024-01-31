package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProJumpChannelInfo {
    long channelId;
    boolean isSwitchOn;

    public GProJumpChannelInfo() {
    }

    public long getChannelId() {
        return this.channelId;
    }

    public boolean getIsSwitchOn() {
        return this.isSwitchOn;
    }

    public String toString() {
        return "GProJumpChannelInfo{isSwitchOn=" + this.isSwitchOn + ",channelId=" + this.channelId + ",}";
    }

    public GProJumpChannelInfo(boolean z, long j2) {
        this.isSwitchOn = z;
        this.channelId = j2;
    }
}
