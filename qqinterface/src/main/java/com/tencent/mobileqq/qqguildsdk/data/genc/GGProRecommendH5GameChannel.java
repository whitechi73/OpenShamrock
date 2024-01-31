package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProRecommendH5GameChannel;

public  class GGProRecommendH5GameChannel implements IGProRecommendH5GameChannel {
    public final GProRecommendH5GameChannel mInfo;

    public GGProRecommendH5GameChannel(GProRecommendH5GameChannel gProRecommendH5GameChannel) {
        this.mInfo = gProRecommendH5GameChannel;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendH5GameChannel
    public IGProRecommendCoverInfo getCover() {
        return new GGProRecommendCoverInfo(this.mInfo.getCover());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendH5GameChannel
    public IGProRecommendH5Game getData() {
        return new GGProRecommendH5Game(this.mInfo.getData());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendH5GameChannel
    public String toString() {
        return this.mInfo.toString();
    }
}
