package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProPlusPanelBotRequest {
    long channelId;
    GProBotClientInfo clientInfo;
    int filter;
    long guildId;
    int page;

    public GProPlusPanelBotRequest() {
        this.clientInfo = new GProBotClientInfo();
    }

    public long getChannelId() {
        return this.channelId;
    }

    public GProBotClientInfo getClientInfo() {
        return this.clientInfo;
    }

    public int getFilter() {
        return this.filter;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public int getPage() {
        return this.page;
    }

    public String toString() {
        return "GProPlusPanelBotRequest{guildId=" + this.guildId + ",channelId=" + this.channelId + ",filter=" + this.filter + ",page=" + this.page + ",clientInfo=" + this.clientInfo + ",}";
    }

    public GProPlusPanelBotRequest(long j2, long j3, int i2, int i3, GProBotClientInfo gProBotClientInfo) {
        this.clientInfo = new GProBotClientInfo();
        this.guildId = j2;
        this.channelId = j3;
        this.filter = i2;
        this.page = i3;
        this.clientInfo = gProBotClientInfo;
    }
}
