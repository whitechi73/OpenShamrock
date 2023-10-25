package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes4.dex */
public final class GProRecommendQuickJoinItem {
    long channelId;
    long guildId;
    String joinSig;
    String mainSource;
    String subSource;

    public GProRecommendQuickJoinItem() {
        this.mainSource = "";
        this.subSource = "";
        this.joinSig = "";
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getJoinSig() {
        return this.joinSig;
    }

    public String getMainSource() {
        return this.mainSource;
    }

    public String getSubSource() {
        return this.subSource;
    }

    public String toString() {
        return "GProRecommendQuickJoinItem{guildId=" + this.guildId + ",channelId=" + this.channelId + ",mainSource=" + this.mainSource + ",subSource=" + this.subSource + ",joinSig=" + this.joinSig + ",}";
    }

    public GProRecommendQuickJoinItem(long j2, long j3, String str, String str2, String str3) {
        this.mainSource = "";
        this.subSource = "";
        this.joinSig = "";
        this.guildId = j2;
        this.channelId = j3;
        this.mainSource = str;
        this.subSource = str2;
        this.joinSig = str3;
    }
}
