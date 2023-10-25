package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes22.dex */
public final class GProUserFreeGiftReq implements Serializable {
    long channelId;
    String checkContext;
    long guildId;
    long serialVersionUID;
    ArrayList<Integer> themeTypes;

    public GProUserFreeGiftReq() {
        this.serialVersionUID = 1L;
        this.checkContext = "";
        this.themeTypes = new ArrayList<>();
    }

    public long getChannelId() {
        return this.channelId;
    }

    public String getCheckContext() {
        return this.checkContext;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public ArrayList<Integer> getThemeTypes() {
        return this.themeTypes;
    }

    public String toString() {
        return "GProUserFreeGiftReq{guildId=" + this.guildId + ",channelId=" + this.channelId + ",checkContext=" + this.checkContext + ",themeTypes=" + this.themeTypes + ",}";
    }

    public GProUserFreeGiftReq(long j2, long j3, String str, ArrayList<Integer> arrayList) {
        this.serialVersionUID = 1L;
        this.checkContext = "";
        this.themeTypes = new ArrayList<>();
        this.guildId = j2;
        this.channelId = j3;
        this.checkContext = str;
        this.themeTypes = arrayList;
    }
}
