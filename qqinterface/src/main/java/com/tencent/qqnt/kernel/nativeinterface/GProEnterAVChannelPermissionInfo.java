package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public  final class GProEnterAVChannelPermissionInfo implements Serializable {
    int roleType;
    long serialVersionUID = 1;

    public GProEnterAVChannelPermissionInfo() {
    }

    public int getRoleType() {
        return this.roleType;
    }

    public String toString() {
        return "GProEnterAVChannelPermissionInfo{roleType=" + this.roleType + ",}";
    }

    public GProEnterAVChannelPermissionInfo(int i2) {
        this.roleType = i2;
    }
}
