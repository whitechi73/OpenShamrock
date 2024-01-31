package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public  final class GProGuildState {
    ArrayList<GProChannelState> channelStateList;
    long guildId;
    long stateSeq;
    GProUserChannelState userChannelState;

    public GProGuildState() {
        this.channelStateList = new ArrayList<>();
        this.userChannelState = new GProUserChannelState();
    }

    public ArrayList<GProChannelState> getChannelStateList() {
        return this.channelStateList;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public long getStateSeq() {
        return this.stateSeq;
    }

    public GProUserChannelState getUserChannelState() {
        return this.userChannelState;
    }

    public String toString() {
        return "GProGuildState{guildId=" + this.guildId + ",channelStateList=" + this.channelStateList + ",stateSeq=" + this.stateSeq + ",userChannelState=" + this.userChannelState + ",}";
    }

    public GProGuildState(long j2, ArrayList<GProChannelState> arrayList, long j3, GProUserChannelState gProUserChannelState) {
        this.channelStateList = new ArrayList<>();
        this.userChannelState = new GProUserChannelState();
        this.guildId = j2;
        this.channelStateList = arrayList;
        this.stateSeq = j3;
        this.userChannelState = gProUserChannelState;
    }
}
