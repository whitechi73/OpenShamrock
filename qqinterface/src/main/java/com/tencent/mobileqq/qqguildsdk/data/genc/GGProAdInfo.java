package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProAdInfo;

public  class GGProAdInfo implements IGProAdInfo {
    public final GProAdInfo mInfo;

    public GGProAdInfo(GProAdInfo gProAdInfo) {
        this.mInfo = gProAdInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAdInfo
    public int getAdId() {
        return this.mInfo.getAdId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAdInfo
    public int getAdType() {
        return this.mInfo.getAdType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAdInfo
    public String getJumpUrl() {
        return this.mInfo.getJumpUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAdInfo
    public String getPicUrl() {
        return this.mInfo.getPicUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAdInfo
    public String getSubTitle() {
        return this.mInfo.getSubTitle();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAdInfo
    public String getTag() {
        return this.mInfo.getTag();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAdInfo
    public String getTitle() {
        return this.mInfo.getTitle();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAdInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
