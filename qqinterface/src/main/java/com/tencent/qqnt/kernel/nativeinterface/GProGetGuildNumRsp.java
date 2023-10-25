package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProGetGuildNumRsp {
    GProGuildNumInfo guildNumInfo;

    public GProGetGuildNumRsp() {
        this.guildNumInfo = new GProGuildNumInfo();
    }

    public GProGuildNumInfo getGuildNumInfo() {
        return this.guildNumInfo;
    }

    public String toString() {
        return "GProGetGuildNumRsp{guildNumInfo=" + this.guildNumInfo + ",}";
    }

    public GProGetGuildNumRsp(GProGuildNumInfo gProGuildNumInfo) {
        this.guildNumInfo = new GProGuildNumInfo();
        this.guildNumInfo = gProGuildNumInfo;
    }
}
