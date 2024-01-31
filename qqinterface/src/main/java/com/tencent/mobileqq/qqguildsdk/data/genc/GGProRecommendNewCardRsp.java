package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProRecommendNewCardRsp;

public  class GGProRecommendNewCardRsp implements IGProRecommendNewCardRsp {
    public final GProRecommendNewCardRsp mInfo;

    public GGProRecommendNewCardRsp(GProRecommendNewCardRsp gProRecommendNewCardRsp) {
        this.mInfo = gProRecommendNewCardRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendNewCardRsp
    public int getNextTs() {
        return this.mInfo.getNextTs();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendNewCardRsp
    public boolean getUpdateFlag() {
        return this.mInfo.getUpdateFlag();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendNewCardRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
