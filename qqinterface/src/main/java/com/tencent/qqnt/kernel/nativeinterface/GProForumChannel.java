package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProForumChannel {
    long channelId;
    String channelName;
    long endColor;
    String guildFaceUrl;
    long guildId;
    String guildName;
    String hotValueTitle;
    int index;
    String joinSign;
    long startColor;
    int type;

    public GProForumChannel() {
        this.guildName = "";
        this.channelName = "";
        this.hotValueTitle = "";
        this.guildFaceUrl = "";
        this.joinSign = "";
    }

    public long getChannelId() {
        return this.channelId;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public long getEndColor() {
        return this.endColor;
    }

    public String getGuildFaceUrl() {
        return this.guildFaceUrl;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getGuildName() {
        return this.guildName;
    }

    public String getHotValueTitle() {
        return this.hotValueTitle;
    }

    public int getIndex() {
        return this.index;
    }

    public String getJoinSign() {
        return this.joinSign;
    }

    public long getStartColor() {
        return this.startColor;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "GProForumChannel{index=" + this.index + ",guildId=" + this.guildId + ",guildName=" + this.guildName + ",channelId=" + this.channelId + ",channelName=" + this.channelName + ",hotValueTitle=" + this.hotValueTitle + ",type=" + this.type + ",guildFaceUrl=" + this.guildFaceUrl + ",startColor=" + this.startColor + ",endColor=" + this.endColor + ",joinSign=" + this.joinSign + ",}";
    }

    public GProForumChannel(int i2, long j2, String str, long j3, String str2, String str3, int i3, String str4, long j4, long j5, String str5) {
        this.guildName = "";
        this.channelName = "";
        this.hotValueTitle = "";
        this.guildFaceUrl = "";
        this.joinSign = "";
        this.index = i2;
        this.guildId = j2;
        this.guildName = str;
        this.channelId = j3;
        this.channelName = str2;
        this.hotValueTitle = str3;
        this.type = i3;
        this.guildFaceUrl = str4;
        this.startColor = j4;
        this.endColor = j5;
        this.joinSign = str5;
    }
}
