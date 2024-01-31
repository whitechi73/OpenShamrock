package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProRecommendShareLive;

import java.util.ArrayList;

public  class GGProRecommendShareLive implements IGProRecommendShareLive {
    public final GProRecommendShareLive mInfo;

    public GGProRecommendShareLive(GProRecommendShareLive gProRecommendShareLive) {
        this.mInfo = gProRecommendShareLive;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendShareLive
    public String getAnchorIcon() {
        return this.mInfo.getAnchorIcon();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendShareLive
    public long getAnchorId() {
        return this.mInfo.getAnchorId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendShareLive
    public ArrayList<String> getAudienceIcons() {
        return this.mInfo.getAudienceIcons();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendShareLive
    public long getChannelId() {
        return this.mInfo.getChannelId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendShareLive
    public long getRoomId() {
        return this.mInfo.getRoomId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendShareLive
    public String getRoomName() {
        return this.mInfo.getRoomName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendShareLive
    public String getStreamUrl() {
        return this.mInfo.getStreamUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendShareLive
    public String toString() {
        return this.mInfo.toString();
    }
}
