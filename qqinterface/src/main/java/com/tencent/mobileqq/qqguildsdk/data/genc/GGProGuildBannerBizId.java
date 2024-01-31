package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProGuildBannerBizId;

public  class GGProGuildBannerBizId implements IGProGuildBannerBizId {
    public final GProGuildBannerBizId mInfo;

    public GGProGuildBannerBizId(GProGuildBannerBizId gProGuildBannerBizId) {
        this.mInfo = gProGuildBannerBizId;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildBannerBizId
    public int getBannerType() {
        return this.mInfo.getBannerType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildBannerBizId
    public long getChannelId() {
        return this.mInfo.getChannelId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildBannerBizId
    public long getFeedCreateTime() {
        return this.mInfo.getFeedCreateTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildBannerBizId
    public long getFeedCreateTinyId() {
        return this.mInfo.getFeedCreateTinyId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildBannerBizId
    public String getFeedId() {
        return this.mInfo.getFeedId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildBannerBizId
    public long getMsgSeq() {
        return this.mInfo.getMsgSeq();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildBannerBizId
    public String getThirdRecommendId() {
        return this.mInfo.getThirdRecommendId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildBannerBizId
    public String toString() {
        return this.mInfo.toString();
    }
}
