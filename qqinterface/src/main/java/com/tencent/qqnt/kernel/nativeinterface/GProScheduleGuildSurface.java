package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProScheduleGuildSurface {
    String channelName;
    String coverUrl;
    int fontColor;
    String guildName;
    String iconUrl;

    public GProScheduleGuildSurface() {
        this.guildName = "";
        this.coverUrl = "";
        this.iconUrl = "";
        this.channelName = "";
    }

    public String getChannelName() {
        return this.channelName;
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public int getFontColor() {
        return this.fontColor;
    }

    public String getGuildName() {
        return this.guildName;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String toString() {
        return "GProScheduleGuildSurface{guildName=" + this.guildName + ",coverUrl=" + this.coverUrl + ",iconUrl=" + this.iconUrl + ",fontColor=" + this.fontColor + ",channelName=" + this.channelName + ",}";
    }

    public GProScheduleGuildSurface(String str, String str2, String str3, int i2, String str4) {
        this.guildName = "";
        this.coverUrl = "";
        this.iconUrl = "";
        this.channelName = "";
        this.guildName = str;
        this.coverUrl = str2;
        this.iconUrl = str3;
        this.fontColor = i2;
        this.channelName = str4;
    }
}
