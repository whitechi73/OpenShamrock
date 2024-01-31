package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProRecommendExtInfo;

public  class GGProRecommendExtInfo implements IGProRecommendExtInfo {
    public final GProRecommendExtInfo mInfo;

    public GGProRecommendExtInfo(GProRecommendExtInfo gProRecommendExtInfo) {
        this.mInfo = gProRecommendExtInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendExtInfo
    public String getTraceId() {
        return this.mInfo.getTraceId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendExtInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
