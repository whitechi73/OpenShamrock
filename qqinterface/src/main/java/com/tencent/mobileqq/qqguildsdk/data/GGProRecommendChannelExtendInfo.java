package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernel.nativeinterface.GProRecommendChannelExtendInfo;

public  class GGProRecommendChannelExtendInfo implements IGProRecommendChannelExtendInfo {
    public final GProRecommendChannelExtendInfo mInfo;

    public GGProRecommendChannelExtendInfo(GProRecommendChannelExtendInfo gProRecommendChannelExtendInfo) {
        this.mInfo = gProRecommendChannelExtendInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProRecommendChannelExtendInfo
    public int getAreaType() {
        return this.mInfo.getAreaType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProRecommendChannelExtendInfo
    public long getChannelId() {
        return this.mInfo.getChannelId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProRecommendChannelExtendInfo
    public String getChannelLink() {
        return this.mInfo.getChannelLink();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProRecommendChannelExtendInfo
    public int getChannelLinkType() {
        return this.mInfo.getChannelLinkType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProRecommendChannelExtendInfo
    public String getGuildFace() {
        return this.mInfo.getGuildFace();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProRecommendChannelExtendInfo
    public int getHideVisitorStyle() {
        return this.mInfo.getHideVisitorStyle();
    }
}
