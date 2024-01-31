package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProTopFeedAbstract;

public  class GGProTopFeedAbstract implements IGProTopFeedAbstract {
    public final GProTopFeedAbstract mInfo;

    public GGProTopFeedAbstract(GProTopFeedAbstract gProTopFeedAbstract) {
        this.mInfo = gProTopFeedAbstract;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProTopFeedAbstract
    public IGProThumbnail getThumbnail() {
        return new GGProThumbnail(this.mInfo.getThumbnail());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProTopFeedAbstract
    public String getTitle() {
        return this.mInfo.getTitle();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProTopFeedAbstract
    public String toString() {
        return this.mInfo.toString();
    }
}
