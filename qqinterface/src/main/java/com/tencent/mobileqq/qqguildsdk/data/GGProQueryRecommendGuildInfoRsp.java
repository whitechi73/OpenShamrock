package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernel.nativeinterface.GProQueryRecommendGuildInfoRsp;

public  class GGProQueryRecommendGuildInfoRsp implements IGProQueryRecommendGuildInfoRsp {
    public final GProQueryRecommendGuildInfoRsp mInfo;

    public GGProQueryRecommendGuildInfoRsp(GProQueryRecommendGuildInfoRsp gProQueryRecommendGuildInfoRsp) {
        this.mInfo = gProQueryRecommendGuildInfoRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProQueryRecommendGuildInfoRsp
    public byte[] getCookie() {
        return this.mInfo.getCookie();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProQueryRecommendGuildInfoRsp
    public IGProGuildData getGuildData() {
        return new GGProGuildData(this.mInfo.getGuildData());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProQueryRecommendGuildInfoRsp
    public long getNewDefaultChannelId() {
        return this.mInfo.getNewDefaultChannelId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProQueryRecommendGuildInfoRsp
    public long getReqInterval() {
        return this.mInfo.getReqInterval();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProQueryRecommendGuildInfoRsp
    public IGProRecommendGuildPersonalSetting getSetting() {
        return new GGProRecommendGuildPersonalSetting(this.mInfo.getSetting());
    }
}
