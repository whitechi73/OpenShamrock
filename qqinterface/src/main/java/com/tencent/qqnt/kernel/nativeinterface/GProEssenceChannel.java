package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public  final class GProEssenceChannel implements Serializable {
    long channelId;
    int channelType;
    String recommend;
    long serialVersionUID;

    public GProEssenceChannel() {
        this.serialVersionUID = 1L;
        this.recommend = "";
    }

    public long getChannelId() {
        return this.channelId;
    }

    public int getChannelType() {
        return this.channelType;
    }

    public String getRecommend() {
        return this.recommend;
    }

    public String toString() {
        return "GProEssenceChannel{channelId=" + this.channelId + ",channelType=" + this.channelType + ",recommend=" + this.recommend + ",}";
    }

    public GProEssenceChannel(long j2, int i2, String str) {
        this.serialVersionUID = 1L;
        this.recommend = "";
        this.channelId = j2;
        this.channelType = i2;
        this.recommend = str;
    }
}
