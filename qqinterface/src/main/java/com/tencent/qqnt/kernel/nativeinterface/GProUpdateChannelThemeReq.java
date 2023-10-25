package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProUpdateChannelThemeReq {
    String authMeta;
    int themeType;
    long uint64ChannelId;
    long uint64GuildId;

    public GProUpdateChannelThemeReq() {
        this.authMeta = "";
    }

    public String getAuthMeta() {
        return this.authMeta;
    }

    public int getThemeType() {
        return this.themeType;
    }

    public long getUint64ChannelId() {
        return this.uint64ChannelId;
    }

    public long getUint64GuildId() {
        return this.uint64GuildId;
    }

    public String toString() {
        return "GProUpdateChannelThemeReq{uint64GuildId=" + this.uint64GuildId + ",uint64ChannelId=" + this.uint64ChannelId + ",authMeta=" + this.authMeta + ",themeType=" + this.themeType + ",}";
    }

    public GProUpdateChannelThemeReq(long j2, long j3, String str, int i2) {
        this.authMeta = "";
        this.uint64GuildId = j2;
        this.uint64ChannelId = j3;
        this.authMeta = str;
        this.themeType = i2;
    }
}
