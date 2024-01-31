package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProAVUserStateChangeInfo {
    long channelId;
    long guildId;

    /* renamed from: msg  reason: collision with root package name */
    String f305530msg;
    GProAVShowMsgInfo showInfo;
    long tinyId;
    GProUserCtlInfo userCtlInfo;

    public GProAVUserStateChangeInfo() {
        this.userCtlInfo = new GProUserCtlInfo();
        this.f305530msg = "";
        this.showInfo = new GProAVShowMsgInfo();
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getMsg() {
        return this.f305530msg;
    }

    public GProAVShowMsgInfo getShowInfo() {
        return this.showInfo;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public GProUserCtlInfo getUserCtlInfo() {
        return this.userCtlInfo;
    }

    public String toString() {
        return "GProAVUserStateChangeInfo{guildId=" + this.guildId + ",channelId=" + this.channelId + ",tinyId=" + this.tinyId + ",userCtlInfo=" + this.userCtlInfo + ",msg=" + this.f305530msg + ",showInfo=" + this.showInfo + ",}";
    }

    public GProAVUserStateChangeInfo(long j2, long j3, long j4, GProUserCtlInfo gProUserCtlInfo, String str, GProAVShowMsgInfo gProAVShowMsgInfo) {
        this.userCtlInfo = new GProUserCtlInfo();
        this.f305530msg = "";
        this.showInfo = new GProAVShowMsgInfo();
        this.guildId = j2;
        this.channelId = j3;
        this.tinyId = j4;
        this.userCtlInfo = gProUserCtlInfo;
        this.f305530msg = str;
        this.showInfo = gProAVShowMsgInfo;
    }
}
