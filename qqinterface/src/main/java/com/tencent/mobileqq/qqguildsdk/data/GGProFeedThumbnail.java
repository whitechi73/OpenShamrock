package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernel.nativeinterface.GProFeedThumbnail;

public  class GGProFeedThumbnail implements IGProFeedThumbnail {
    public final GProFeedThumbnail mInfo;

    public GGProFeedThumbnail(GProFeedThumbnail gProFeedThumbnail) {
        this.mInfo = gProFeedThumbnail;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProFeedThumbnail
    public boolean getIsVideoCover() {
        return this.mInfo.getIsVideoCover();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProFeedThumbnail
    public String getUrl() {
        return this.mInfo.getUrl();
    }
}
