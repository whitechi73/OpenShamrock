package com.tencent.qqnt.kernel.nativeinterface;


public  final class FeedChannelInfo {
    String guildName;
    String iconUrl;
    String name;
    CHANNELPRIVATETYPE privateType;
    ChannelSign sign;

    public FeedChannelInfo() {
        this.sign = new ChannelSign();
        this.name = "";
        this.privateType = CHANNELPRIVATETYPE.values()[0];
        this.guildName = "";
        this.iconUrl = "";
    }

    public String getGuildName() {
        return this.guildName;
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public String getName() {
        return this.name;
    }

    public CHANNELPRIVATETYPE getPrivateType() {
        return this.privateType;
    }

    public ChannelSign getSign() {
        return this.sign;
    }

    public String toString() {
        return "FeedChannelInfo{sign=" + this.sign + ",name=" + this.name + ",privateType=" + this.privateType + ",guildName=" + this.guildName + ",iconUrl=" + this.iconUrl + ",}";
    }

    public FeedChannelInfo(ChannelSign channelSign, String str, CHANNELPRIVATETYPE channelprivatetype, String str2, String str3) {
        this.sign = new ChannelSign();
        this.name = "";
        this.privateType = CHANNELPRIVATETYPE.values()[0];
        this.guildName = "";
        this.iconUrl = "";
        this.sign = channelSign;
        this.name = str;
        this.privateType = channelprivatetype;
        this.guildName = str2;
        this.iconUrl = str3;
    }
}
