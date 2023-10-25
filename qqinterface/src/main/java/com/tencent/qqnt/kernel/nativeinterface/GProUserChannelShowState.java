package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProUserChannelShowState implements Serializable {
    long serialVersionUID;
    String stateIcon;
    String stateInfo;

    public GProUserChannelShowState() {
        this.serialVersionUID = 1L;
        this.stateIcon = "";
        this.stateInfo = "";
    }

    public String getStateIcon() {
        return this.stateIcon;
    }

    public String getStateInfo() {
        return this.stateInfo;
    }

    public String toString() {
        return "GProUserChannelShowState{stateIcon=" + this.stateIcon + ",stateInfo=" + this.stateInfo + ",}";
    }

    public GProUserChannelShowState(String str, String str2) {
        this.serialVersionUID = 1L;
        this.stateIcon = "";
        this.stateInfo = "";
        this.stateIcon = str;
        this.stateInfo = str2;
    }
}
