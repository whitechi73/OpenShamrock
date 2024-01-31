package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProSwitchInfo;

public  class GGProSwitchInfo implements IGProSwitchInfo {
    public final GProSwitchInfo mInfo;

    public GGProSwitchInfo(GProSwitchInfo gProSwitchInfo) {
        this.mInfo = gProSwitchInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSwitchInfo
    public int getCloseReason() {
        return this.mInfo.getCloseReason();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSwitchInfo
    public int getSwitchState() {
        return this.mInfo.getSwitchState();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSwitchInfo
    public int getSwitchType() {
        return this.mInfo.getSwitchType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSwitchInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
