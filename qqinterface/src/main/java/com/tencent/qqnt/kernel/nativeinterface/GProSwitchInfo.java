package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProSwitchInfo implements Serializable {
    int closeReason;
    long serialVersionUID = 1;
    int switchState;
    int switchType;

    public GProSwitchInfo() {
    }

    public int getCloseReason() {
        return this.closeReason;
    }

    public int getSwitchState() {
        return this.switchState;
    }

    public int getSwitchType() {
        return this.switchType;
    }

    public String toString() {
        return "GProSwitchInfo{switchType=" + this.switchType + ",switchState=" + this.switchState + ",closeReason=" + this.closeReason + ",}";
    }

    public GProSwitchInfo(int i2, int i3, int i4) {
        this.switchType = i2;
        this.switchState = i3;
        this.closeReason = i4;
    }
}
