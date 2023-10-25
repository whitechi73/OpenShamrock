package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProChannelStateItemInfo implements Serializable {
    int channelState;
    long serialVersionUID = 1;
    int statePriority;

    public GProChannelStateItemInfo() {
    }

    public int getChannelState() {
        return this.channelState;
    }

    public int getStatePriority() {
        return this.statePriority;
    }

    public String toString() {
        return "GProChannelStateItemInfo{channelState=" + this.channelState + ",statePriority=" + this.statePriority + ",}";
    }

    public GProChannelStateItemInfo(int i2, int i3) {
        this.channelState = i2;
        this.statePriority = i3;
    }
}
