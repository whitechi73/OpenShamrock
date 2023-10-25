package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProGuildStateRspInfo {
    ArrayList<GProGuildState> guildStatusList;
    long nextTs;
    GProUserChannelState userStateInfo;

    public GProGuildStateRspInfo() {
        this.guildStatusList = new ArrayList<>();
        this.userStateInfo = new GProUserChannelState();
    }

    public ArrayList<GProGuildState> getGuildStatusList() {
        return this.guildStatusList;
    }

    public long getNextTs() {
        return this.nextTs;
    }

    public GProUserChannelState getUserStateInfo() {
        return this.userStateInfo;
    }

    public String toString() {
        return "GProGuildStateRspInfo{guildStatusList=" + this.guildStatusList + ",nextTs=" + this.nextTs + ",userStateInfo=" + this.userStateInfo + ",}";
    }

    public GProGuildStateRspInfo(ArrayList<GProGuildState> arrayList, long j2, GProUserChannelState gProUserChannelState) {
        this.guildStatusList = new ArrayList<>();
        this.userStateInfo = new GProUserChannelState();
        this.guildStatusList = arrayList;
        this.nextTs = j2;
        this.userStateInfo = gProUserChannelState;
    }
}
