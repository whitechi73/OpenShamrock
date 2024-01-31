package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProRecommendShareInfo;

public  class GGProRecommendShareInfo implements IGProRecommendShareInfo {
    public final GProRecommendShareInfo mInfo;

    public GGProRecommendShareInfo(GProRecommendShareInfo gProRecommendShareInfo) {
        this.mInfo = gProRecommendShareInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendShareInfo
    public IGProBusinessData getBizData() {
        return new GGProBusinessData(this.mInfo.getBizData());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendShareInfo
    public long getChannelId() {
        return this.mInfo.getChannelId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendShareInfo
    public String getGuildCoverUrl() {
        return this.mInfo.getGuildCoverUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendShareInfo
    public String getGuildIcon() {
        return this.mInfo.getGuildIcon();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendShareInfo
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendShareInfo
    public String getGuildName() {
        return this.mInfo.getGuildName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendShareInfo
    public String getJoinGuildSig() {
        return this.mInfo.getJoinGuildSig();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendShareInfo
    public int getJoinedGuild() {
        return this.mInfo.getJoinedGuild();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendShareInfo
    public int getMemberRole() {
        return this.mInfo.getMemberRole();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendShareInfo
    public String getShareLink() {
        return this.mInfo.getShareLink();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendShareInfo
    public IGProRecommendShareLive getShareLive() {
        return new GGProRecommendShareLive(this.mInfo.getShareLive());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendShareInfo
    public int getShareTag() {
        return this.mInfo.getShareTag();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendShareInfo
    public int getShareType() {
        return this.mInfo.getShareType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendShareInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
