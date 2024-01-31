package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public  final class GProHeartbeatRsq implements Serializable {
    GProAVChannelConfig avChannelConfig;
    long channelId;
    int forceExit;
    long guildId;
    long nextHeartBeatInterval;
    long noStreamDisconnectTrtcSecond;
    long serialVersionUID;
    String showTips;

    public GProHeartbeatRsq() {
        this.serialVersionUID = 1L;
        this.showTips = "";
        this.avChannelConfig = new GProAVChannelConfig();
    }

    public GProAVChannelConfig getAvChannelConfig() {
        return this.avChannelConfig;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public int getForceExit() {
        return this.forceExit;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public long getNextHeartBeatInterval() {
        return this.nextHeartBeatInterval;
    }

    public long getNoStreamDisconnectTrtcSecond() {
        return this.noStreamDisconnectTrtcSecond;
    }

    public String getShowTips() {
        return this.showTips;
    }

    public String toString() {
        return "GProHeartbeatRsq{guildId=" + this.guildId + ",channelId=" + this.channelId + ",nextHeartBeatInterval=" + this.nextHeartBeatInterval + ",forceExit=" + this.forceExit + ",showTips=" + this.showTips + ",avChannelConfig=" + this.avChannelConfig + ",noStreamDisconnectTrtcSecond=" + this.noStreamDisconnectTrtcSecond + ",}";
    }

    public GProHeartbeatRsq(long j2, long j3, long j4, int i2, String str, GProAVChannelConfig gProAVChannelConfig, long j5) {
        this.serialVersionUID = 1L;
        this.showTips = "";
        this.avChannelConfig = new GProAVChannelConfig();
        this.guildId = j2;
        this.channelId = j3;
        this.nextHeartBeatInterval = j4;
        this.forceExit = i2;
        this.showTips = str;
        this.avChannelConfig = gProAVChannelConfig;
        this.noStreamDisconnectTrtcSecond = j5;
    }
}
