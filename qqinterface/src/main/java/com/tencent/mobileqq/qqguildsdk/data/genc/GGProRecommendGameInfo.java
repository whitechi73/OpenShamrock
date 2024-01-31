package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProRecommendGameInfo;

public  class GGProRecommendGameInfo implements IGProRecommendGameInfo {
    public final GProRecommendGameInfo mInfo;

    public GGProRecommendGameInfo(GProRecommendGameInfo gProRecommendGameInfo) {
        this.mInfo = gProRecommendGameInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendGameInfo
    public String getIcon() {
        return this.mInfo.getIcon();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendGameInfo
    public int getId() {
        return this.mInfo.getId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendGameInfo
    public IGProRecommendModeInfo getModeInfo() {
        return new GGProRecommendModeInfo(this.mInfo.getModeInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendGameInfo
    public String getName() {
        return this.mInfo.getName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendGameInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
