package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProJoinGuildResult {
    GProGuild guildInfo;
    GProGuildInit guildInit;
    int isOpenTab;
    int qqMsgInList;
    GProSecurityResult secResult;

    public GProJoinGuildResult() {
        this.secResult = new GProSecurityResult();
        this.guildInfo = new GProGuild();
        this.guildInit = new GProGuildInit();
    }

    public GProGuild getGuildInfo() {
        return this.guildInfo;
    }

    public GProGuildInit getGuildInit() {
        return this.guildInit;
    }

    public int getIsOpenTab() {
        return this.isOpenTab;
    }

    public int getQqMsgInList() {
        return this.qqMsgInList;
    }

    public GProSecurityResult getSecResult() {
        return this.secResult;
    }

    public String toString() {
        return "GProJoinGuildResult{secResult=" + this.secResult + ",guildInfo=" + this.guildInfo + ",guildInit=" + this.guildInit + ",qqMsgInList=" + this.qqMsgInList + ",isOpenTab=" + this.isOpenTab + ",}";
    }

    public GProJoinGuildResult(GProSecurityResult gProSecurityResult, GProGuild gProGuild, GProGuildInit gProGuildInit, int i2, int i3) {
        this.secResult = new GProSecurityResult();
        this.guildInfo = new GProGuild();
        this.guildInit = new GProGuildInit();
        this.secResult = gProSecurityResult;
        this.guildInfo = gProGuild;
        this.guildInit = gProGuildInit;
        this.qqMsgInList = i2;
        this.isOpenTab = i3;
    }
}
