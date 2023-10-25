package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProQueryRecommendGuildInfoRsp {
    byte[] cookie;
    GProGuildData guildData;
    long newDefaultChannelId;
    long reqInterval;
    GProRecommendGuildPersonalSetting setting;

    public GProQueryRecommendGuildInfoRsp() {
        this.guildData = new GProGuildData();
        this.setting = new GProRecommendGuildPersonalSetting();
        this.cookie = new byte[0];
    }

    public byte[] getCookie() {
        return this.cookie;
    }

    public GProGuildData getGuildData() {
        return this.guildData;
    }

    public long getNewDefaultChannelId() {
        return this.newDefaultChannelId;
    }

    public long getReqInterval() {
        return this.reqInterval;
    }

    public GProRecommendGuildPersonalSetting getSetting() {
        return this.setting;
    }

    public String toString() {
        return "GProQueryRecommendGuildInfoRsp{guildData=" + this.guildData + ",setting=" + this.setting + ",reqInterval=" + this.reqInterval + ",cookie=" + this.cookie + ",newDefaultChannelId=" + this.newDefaultChannelId + ",}";
    }

    public GProQueryRecommendGuildInfoRsp(GProGuildData gProGuildData, GProRecommendGuildPersonalSetting gProRecommendGuildPersonalSetting, long j2, byte[] bArr, long j3) {
        this.guildData = new GProGuildData();
        this.setting = new GProRecommendGuildPersonalSetting();
        this.cookie = new byte[0];
        this.guildData = gProGuildData;
        this.setting = gProRecommendGuildPersonalSetting;
        this.reqInterval = j2;
        this.cookie = bArr;
        this.newDefaultChannelId = j3;
    }
}
