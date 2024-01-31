package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProAuthControlSwitchInfo {
    int Permission;
    int authControlSwitchType;

    public GProAuthControlSwitchInfo() {
    }

    public int getAuthControlSwitchType() {
        return this.authControlSwitchType;
    }

    public int getPermission() {
        return this.Permission;
    }

    public String toString() {
        return "GProAuthControlSwitchInfo{authControlSwitchType=" + this.authControlSwitchType + ",Permission=" + this.Permission + ",}";
    }

    public GProAuthControlSwitchInfo(int i2, int i3) {
        this.authControlSwitchType = i2;
        this.Permission = i3;
    }
}
