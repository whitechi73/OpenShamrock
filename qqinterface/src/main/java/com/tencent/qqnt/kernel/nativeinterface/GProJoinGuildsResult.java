package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public  final class GProJoinGuildsResult implements Serializable {
    long guildId;
    GProGuild guildInfo;
    GProGuildInit guildInit;
    int isOpenTab;
    int qqMsgInList;
    int resultCode;
    GProSecurityResult secResult;
    long serialVersionUID;

    public GProJoinGuildsResult() {
        this.serialVersionUID = 1L;
        this.secResult = new GProSecurityResult();
        this.guildInfo = new GProGuild();
        this.guildInit = new GProGuildInit();
    }

    public long getGuildId() {
        return this.guildId;
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

    public int getResultCode() {
        return this.resultCode;
    }

    public GProSecurityResult getSecResult() {
        return this.secResult;
    }

    public String toString() {
        return "GProJoinGuildsResult{resultCode=" + this.resultCode + ",secResult=" + this.secResult + ",guildId=" + this.guildId + ",guildInfo=" + this.guildInfo + ",guildInit=" + this.guildInit + ",qqMsgInList=" + this.qqMsgInList + ",isOpenTab=" + this.isOpenTab + ",}";
    }

    public GProJoinGuildsResult(int i2, GProSecurityResult gProSecurityResult, long j2, GProGuild gProGuild, GProGuildInit gProGuildInit, int i3, int i4) {
        this.serialVersionUID = 1L;
        this.secResult = new GProSecurityResult();
        this.guildInfo = new GProGuild();
        this.guildInit = new GProGuildInit();
        this.resultCode = i2;
        this.secResult = gProSecurityResult;
        this.guildId = j2;
        this.guildInfo = gProGuild;
        this.guildInit = gProGuildInit;
        this.qqMsgInList = i3;
        this.isOpenTab = i4;
    }
}
