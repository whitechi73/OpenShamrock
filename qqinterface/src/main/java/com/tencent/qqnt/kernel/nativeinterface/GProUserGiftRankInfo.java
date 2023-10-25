package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes22.dex */
public final class GProUserGiftRankInfo implements Serializable {
    long channelId;
    long guildId;
    String jumpUrl;
    String rankInfo;
    long serialVersionUID;
    int topNum;
    GProUser userInfo;

    public GProUserGiftRankInfo() {
        this.serialVersionUID = 1L;
        this.userInfo = new GProUser();
        this.rankInfo = "";
        this.jumpUrl = "";
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getJumpUrl() {
        return this.jumpUrl;
    }

    public String getRankInfo() {
        return this.rankInfo;
    }

    public int getTopNum() {
        return this.topNum;
    }

    public GProUser getUserInfo() {
        return this.userInfo;
    }

    public String toString() {
        return "GProUserGiftRankInfo{guildId=" + this.guildId + ",channelId=" + this.channelId + ",userInfo=" + this.userInfo + ",rankInfo=" + this.rankInfo + ",topNum=" + this.topNum + ",jumpUrl=" + this.jumpUrl + ",}";
    }

    public GProUserGiftRankInfo(long j2, long j3, GProUser gProUser, String str, int i2, String str2) {
        this.serialVersionUID = 1L;
        this.userInfo = new GProUser();
        this.rankInfo = "";
        this.jumpUrl = "";
        this.guildId = j2;
        this.channelId = j3;
        this.userInfo = gProUser;
        this.rankInfo = str;
        this.topNum = i2;
        this.jumpUrl = str2;
    }
}
