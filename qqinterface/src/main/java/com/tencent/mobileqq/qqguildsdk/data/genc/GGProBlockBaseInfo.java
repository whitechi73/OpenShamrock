package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProBlockBaseInfo;

public  class GGProBlockBaseInfo implements IGProBlockBaseInfo {
    public final GProBlockBaseInfo mInfo;

    public GGProBlockBaseInfo(GProBlockBaseInfo gProBlockBaseInfo) {
        this.mInfo = gProBlockBaseInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBlockBaseInfo
    public IGProRecommendV2Channel getChannel() {
        return new GGProRecommendV2Channel(this.mInfo.getChannel());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBlockBaseInfo
    public IGProRecommendsV2Feed getFeed() {
        return new GGProRecommendsV2Feed(this.mInfo.getFeed());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBlockBaseInfo
    public IGProRecommendShareInfo getShareInfo() {
        return new GGProRecommendShareInfo(this.mInfo.getShareInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBlockBaseInfo
    public int getType() {
        return this.mInfo.getType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBlockBaseInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
