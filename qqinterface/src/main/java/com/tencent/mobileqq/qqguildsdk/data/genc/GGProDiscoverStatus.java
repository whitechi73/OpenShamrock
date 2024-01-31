package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProDiscoverStatus;

public  class GGProDiscoverStatus implements IGProDiscoverStatus {
    public final GProDiscoverStatus mInfo;

    public GGProDiscoverStatus(GProDiscoverStatus gProDiscoverStatus) {
        this.mInfo = gProDiscoverStatus;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProDiscoverStatus
    public int getNextTs() {
        return this.mInfo.getNextTs();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProDiscoverStatus
    public int getState() {
        return this.mInfo.getState();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProDiscoverStatus
    public int getType() {
        return this.mInfo.getType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProDiscoverStatus
    public String toString() {
        return this.mInfo.toString();
    }
}
