package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProGuildStateReqInfo {
    ArrayList<Long> channelIdList;
    long guildId;
    long stateSeq;

    public GProGuildStateReqInfo() {
        this.channelIdList = new ArrayList<>();
    }

    public ArrayList<Long> getChannelIdList() {
        return this.channelIdList;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public long getStateSeq() {
        return this.stateSeq;
    }

    public String toString() {
        return "GProGuildStateReqInfo{guildId=" + this.guildId + ",channelIdList=" + this.channelIdList + ",stateSeq=" + this.stateSeq + ",}";
    }

    public GProGuildStateReqInfo(long j2, ArrayList<Long> arrayList, long j3) {
        this.channelIdList = new ArrayList<>();
        this.guildId = j2;
        this.channelIdList = arrayList;
        this.stateSeq = j3;
    }
}
