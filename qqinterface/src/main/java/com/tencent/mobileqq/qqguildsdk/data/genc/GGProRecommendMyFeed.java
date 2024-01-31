package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProRecommendMyFeed;

public  class GGProRecommendMyFeed implements IGProRecommendMyFeed {
    public final GProRecommendMyFeed mInfo;

    public GGProRecommendMyFeed(GProRecommendMyFeed gProRecommendMyFeed) {
        this.mInfo = gProRecommendMyFeed;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendMyFeed
    public byte[] getData() {
        return this.mInfo.getData();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendMyFeed
    public IGProPosterInfo getPoster() {
        return null;
        //return new GGProPosterInfo(this.mInfo.getPoster());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendMyFeed
    public IGProRecommendFeedShareInfo getShareInfo() {
        return new GGProRecommendFeedShareInfo(this.mInfo.getShareInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendMyFeed
    public String toString() {
        return this.mInfo.toString();
    }
}
