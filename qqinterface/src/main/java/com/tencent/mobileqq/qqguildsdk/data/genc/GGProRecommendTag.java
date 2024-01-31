package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProRecommendTag;

public  class GGProRecommendTag implements IGProRecommendTag {
    public final GProRecommendTag mInfo;

    public GGProRecommendTag(GProRecommendTag gProRecommendTag) {
        this.mInfo = gProRecommendTag;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendTag
    public String getIcon() {
        return this.mInfo.getIcon();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendTag
    public String getName() {
        return this.mInfo.getName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendTag
    public String toString() {
        return this.mInfo.toString();
    }
}
