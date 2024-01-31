package com.tencent.qqnt.kernel.nativeinterface;


public  final class ChannelSign {
    String channelId;
    String guildId;

    public ChannelSign() {
        this.guildId = "";
        this.channelId = "";
    }

    public String getChannelId() {
        return this.channelId;
    }

    public String getGuildId() {
        return this.guildId;
    }

    public String toString() {
        return "ChannelSign{guildId=" + this.guildId + ",channelId=" + this.channelId + ",}";
    }

    public ChannelSign(String str, String str2) {
        this.guildId = "";
        this.channelId = "";
        this.guildId = str;
        this.channelId = str2;
    }
}
