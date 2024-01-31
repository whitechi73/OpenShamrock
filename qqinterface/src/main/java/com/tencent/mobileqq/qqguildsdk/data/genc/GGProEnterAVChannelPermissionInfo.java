package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProEnterAVChannelPermissionInfo;

public  class GGProEnterAVChannelPermissionInfo implements IGProEnterAVChannelPermissionInfo {
    public final GProEnterAVChannelPermissionInfo mInfo;

    public GGProEnterAVChannelPermissionInfo(GProEnterAVChannelPermissionInfo gProEnterAVChannelPermissionInfo) {
        this.mInfo = gProEnterAVChannelPermissionInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProEnterAVChannelPermissionInfo
    public int getRoleType() {
        return this.mInfo.getRoleType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProEnterAVChannelPermissionInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
