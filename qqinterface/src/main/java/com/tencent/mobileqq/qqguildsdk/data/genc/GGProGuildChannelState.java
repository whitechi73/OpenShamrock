package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProGuildChannelState;

import java.io.Serializable;

public  class GGProGuildChannelState implements Serializable {
    public final GProGuildChannelState mInfo;

    public GGProGuildChannelState(GProGuildChannelState gProGuildChannelState) {
        this.mInfo = gProGuildChannelState;
    }

    public String getDesc() {
        return this.mInfo.getDesc();
    }

    public int getState() {
        return this.mInfo.getState();
    }

    public String toString() {
        return this.mInfo.toString();
    }
}
