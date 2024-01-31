package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProFeedImageEntity;

public  class GGProFeedImageEntity implements IGProFeedImageEntity {
    public final GProFeedImageEntity mInfo;

    public GGProFeedImageEntity(GProFeedImageEntity gProFeedImageEntity) {
        this.mInfo = gProFeedImageEntity;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProFeedImageEntity
    public int getHeight() {
        return this.mInfo.getHeight();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProFeedImageEntity
    public String getUrl() {
        return this.mInfo.getUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProFeedImageEntity
    public int getWidth() {
        return this.mInfo.getWidth();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProFeedImageEntity
    public String toString() {
        return this.mInfo.toString();
    }
}
