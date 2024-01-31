package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProGetRecommendV2Rsp;

public  class GGProGetRecommendV2Rsp implements IGProGetRecommendV2Rsp {
    public final GProGetRecommendV2Rsp mInfo;

    public GGProGetRecommendV2Rsp(GProGetRecommendV2Rsp gProGetRecommendV2Rsp) {
        this.mInfo = gProGetRecommendV2Rsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRecommendV2Rsp
    public IGProBannerBlockList getBanners() {
        return new GGProBannerBlockList(this.mInfo.getBanners());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRecommendV2Rsp
    public byte[] getCookies() {
        return this.mInfo.getCookies();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRecommendV2Rsp
    public int getDiscoverType() {
        return this.mInfo.getDiscoverType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRecommendV2Rsp
    public IGProRecommendExtInfo getExtInfo() {
        return new GGProRecommendExtInfo(this.mInfo.getExtInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRecommendV2Rsp
    public IGProPopBlockList getPopups() {
        return new GGProPopBlockList(this.mInfo.getPopups());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRecommendV2Rsp
    public IGProRecommendV2TracksBlockList getTracks() {
        return new GGProRecommendV2TracksBlockList(this.mInfo.getTracks());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRecommendV2Rsp
    public String toString() {
        return this.mInfo.toString();
    }
}
