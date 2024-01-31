package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProAudioLiveUserListReq {
    long channelId;
    long guildId;
    boolean needChannelState;
    int numIndex;
    int onceGetNum;
    boolean onlyHandUpList;
    boolean onlySpeakOrderList;

    public GProAudioLiveUserListReq() {
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public boolean getNeedChannelState() {
        return this.needChannelState;
    }

    public int getNumIndex() {
        return this.numIndex;
    }

    public int getOnceGetNum() {
        return this.onceGetNum;
    }

    public boolean getOnlyHandUpList() {
        return this.onlyHandUpList;
    }

    public boolean getOnlySpeakOrderList() {
        return this.onlySpeakOrderList;
    }

    public String toString() {
        return "GProAudioLiveUserListReq{guildId=" + this.guildId + ",channelId=" + this.channelId + ",onceGetNum=" + this.onceGetNum + ",needChannelState=" + this.needChannelState + ",onlyHandUpList=" + this.onlyHandUpList + ",onlySpeakOrderList=" + this.onlySpeakOrderList + ",numIndex=" + this.numIndex + ",}";
    }

    public GProAudioLiveUserListReq(long j2, long j3, int i2, boolean z, boolean z2, boolean z3, int i3) {
        this.guildId = j2;
        this.channelId = j3;
        this.onceGetNum = i2;
        this.needChannelState = z;
        this.onlyHandUpList = z2;
        this.onlySpeakOrderList = z3;
        this.numIndex = i3;
    }
}
