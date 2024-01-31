package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProTopFeed;

public  class GGProTopFeed implements IGProTopFeed {
    public final GProTopFeed mInfo;

    public GGProTopFeed(GProTopFeed gProTopFeed) {
        this.mInfo = gProTopFeed;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProTopFeed
    public long getCreateTime() {
        return this.mInfo.getCreateTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProTopFeed
    public IGProTopFeedAbstract getFeedAbstract() {
        return new GGProTopFeedAbstract(this.mInfo.getFeedAbstract());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProTopFeed
    public String getFeedId() {
        return this.mInfo.getFeedId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProTopFeed
    public long getOperatorTinyId() {
        return this.mInfo.getOperatorTinyId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProTopFeed
    public long getTopTimestamp() {
        return this.mInfo.getTopTimestamp();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProTopFeed
    public String getUserId() {
        return this.mInfo.getUserId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProTopFeed
    public String toString() {
        return this.mInfo.toString();
    }
}
