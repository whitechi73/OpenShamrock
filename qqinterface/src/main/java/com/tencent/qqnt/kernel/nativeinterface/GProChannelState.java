package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProChannelState implements Serializable {
    long channelId;
    int channelState;
    ArrayList<GProChannelStateItemInfo> channelStateList;
    long channelStateSeq;
    int channelType;
    long guildId;
    long serialVersionUID;

    public GProChannelState() {
        this.serialVersionUID = 1L;
        this.channelStateList = new ArrayList<>();
    }

    public long getChannelId() {
        return this.channelId;
    }

    public int getChannelState() {
        return this.channelState;
    }

    public ArrayList<GProChannelStateItemInfo> getChannelStateList() {
        return this.channelStateList;
    }

    public long getChannelStateSeq() {
        return this.channelStateSeq;
    }

    public int getChannelType() {
        return this.channelType;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String toString() {
        return "GProChannelState{guildId=" + this.guildId + ",channelId=" + this.channelId + ",channelState=" + this.channelState + ",channelType=" + this.channelType + ",channelStateList=" + this.channelStateList + ",channelStateSeq=" + this.channelStateSeq + ",}";
    }

    public GProChannelState(long j2, long j3, int i2, int i3, ArrayList<GProChannelStateItemInfo> arrayList, long j4) {
        this.serialVersionUID = 1L;
        this.channelStateList = new ArrayList<>();
        this.guildId = j2;
        this.channelId = j3;
        this.channelState = i2;
        this.channelType = i3;
        this.channelStateList = arrayList;
        this.channelStateSeq = j4;
    }
}
