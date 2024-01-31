package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProGuidePageInfo;

public  class GGProGuidePageInfo implements IGProGuidePageInfo {
    public final GProGuidePageInfo mInfo;

    public GGProGuidePageInfo(GProGuidePageInfo gProGuidePageInfo) {
        this.mInfo = gProGuidePageInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuidePageInfo
    public String getDesc() {
        return this.mInfo.getDesc();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuidePageInfo
    public IGProImgPair getImages() {
        return new GGProImgPair(this.mInfo.getImages());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuidePageInfo
    public String getTitle() {
        return this.mInfo.getTitle();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuidePageInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
