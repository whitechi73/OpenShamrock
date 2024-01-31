package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProRecommendCategory;

public  class GGProRecommendCategory implements IGProRecommendCategory {
    public final GProRecommendCategory mInfo;

    public GGProRecommendCategory(GProRecommendCategory gProRecommendCategory) {
        this.mInfo = gProRecommendCategory;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendCategory
    public int getCategoryId() {
        return this.mInfo.getCategoryId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendCategory
    public int getCategoryType() {
        return this.mInfo.getCategoryType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendCategory
    public String getGroupId() {
        return this.mInfo.getGroupId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendCategory
    public boolean getHasMore() {
        return this.mInfo.getHasMore();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendCategory
    public String getName() {
        return this.mInfo.getName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendCategory
    public String getType() {
        return this.mInfo.getType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendCategory
    public String toString() {
        return this.mInfo.toString();
    }
}
