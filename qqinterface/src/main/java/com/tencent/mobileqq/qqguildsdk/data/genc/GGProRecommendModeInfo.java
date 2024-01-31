package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProRecommendModeInfo;

public  class GGProRecommendModeInfo implements IGProRecommendModeInfo {
    public final GProRecommendModeInfo mInfo;

    public GGProRecommendModeInfo(GProRecommendModeInfo gProRecommendModeInfo) {
        this.mInfo = gProRecommendModeInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendModeInfo
    public boolean getIsPK() {
        return this.mInfo.getIsPK();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendModeInfo
    public int getModeId() {
        return this.mInfo.getModeId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendModeInfo
    public String getModeName() {
        return this.mInfo.getModeName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendModeInfo
    public int getPlayerNum() {
        return this.mInfo.getPlayerNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendModeInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
