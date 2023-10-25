package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProChannelAdminInfo {
    long channelAdminNum;
    long channelId;
    String channelName;
    int channelType;

    public GProChannelAdminInfo() {
        this.channelName = "";
    }

    public long getChannelAdminNum() {
        return this.channelAdminNum;
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

    public String toString() {
        return "GProChannelAdminInfo{channelId=" + this.channelId + ",channelName=" + this.channelName + ",channelType=" + this.channelType + ",channelAdminNum=" + this.channelAdminNum + ",}";
    }

    public GProChannelAdminInfo(long j2, String str, int i2, long j3) {
        this.channelName = "";
        this.channelId = j2;
        this.channelName = str;
        this.channelType = i2;
        this.channelAdminNum = j3;
    }
}
