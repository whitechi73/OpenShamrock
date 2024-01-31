package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.GGProDiscoverStatus;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProDiscoverStatus;
import com.tencent.qqnt.kernel.nativeinterface.GProMyRecommendMsg;

public  class GGProMyRecommendMsg implements IGProMyRecommendMsg {
    public final GProMyRecommendMsg mInfo;

    public GGProMyRecommendMsg(GProMyRecommendMsg gProMyRecommendMsg) {
        this.mInfo = gProMyRecommendMsg;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProMyRecommendMsg
    public int getBusinessType() {
        return this.mInfo.getBusinessType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProMyRecommendMsg
    public IGProDiscoverStatus getDiscoverStatus() {
        return new GGProDiscoverStatus(this.mInfo.getDiscoverStatus());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProMyRecommendMsg
    public int getFlag() {
        return this.mInfo.getFlag();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProMyRecommendMsg
    public int getPointType() {
        return this.mInfo.getPointType();
    }
}
