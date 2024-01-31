package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProGetRedPointRsp {
    String avatar;
    int businessType;
    long channelId;
    long guildId;
    boolean hasRedPoint;
    String iconUrl;
    boolean isJoinGuild;
    String transBuffer;
    int watchCycle;

    public GProGetRedPointRsp() {
        this.avatar = "";
        this.iconUrl = "";
        this.transBuffer = "";
    }

    public String getAvatar() {
        return this.avatar;
    }

    public int getBusinessType() {
        return this.businessType;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public boolean getHasRedPoint() {
        return this.hasRedPoint;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public boolean getIsJoinGuild() {
        return this.isJoinGuild;
    }

    public String getTransBuffer() {
        return this.transBuffer;
    }

    public int getWatchCycle() {
        return this.watchCycle;
    }

    public String toString() {
        return "GProGetRedPointRsp{hasRedPoint=" + this.hasRedPoint + ",businessType=" + this.businessType + ",guildId=" + this.guildId + ",channelId=" + this.channelId + ",avatar=" + this.avatar + ",isJoinGuild=" + this.isJoinGuild + ",watchCycle=" + this.watchCycle + ",iconUrl=" + this.iconUrl + ",transBuffer=" + this.transBuffer + ",}";
    }

    public GProGetRedPointRsp(boolean z, int i2, long j2, long j3, String str, boolean z2, int i3, String str2, String str3) {
        this.avatar = "";
        this.iconUrl = "";
        this.transBuffer = "";
        this.hasRedPoint = z;
        this.businessType = i2;
        this.guildId = j2;
        this.channelId = j3;
        this.avatar = str;
        this.isJoinGuild = z2;
        this.watchCycle = i3;
        this.iconUrl = str2;
        this.transBuffer = str3;
    }
}
