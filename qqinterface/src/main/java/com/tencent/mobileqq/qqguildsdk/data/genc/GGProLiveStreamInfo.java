package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProLiveStreamInfo;

public  class GGProLiveStreamInfo implements IGProLiveStreamInfo {
    public final GProLiveStreamInfo mInfo;

    public GGProLiveStreamInfo(GProLiveStreamInfo gProLiveStreamInfo) {
        this.mInfo = gProLiveStreamInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLiveStreamInfo
    public long getAnchorId() {
        return this.mInfo.getAnchorId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLiveStreamInfo
    public String getFlvUrl() {
        return this.mInfo.getFlvUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLiveStreamInfo
    public String getUrl() {
        return this.mInfo.getUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLiveStreamInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
