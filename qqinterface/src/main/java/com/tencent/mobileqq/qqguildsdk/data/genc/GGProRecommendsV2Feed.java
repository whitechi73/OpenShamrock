package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProRecommendsV2Feed;

import java.util.ArrayList;

public  class GGProRecommendsV2Feed implements IGProRecommendsV2Feed {
    public final GProRecommendsV2Feed mInfo;

    public GGProRecommendsV2Feed(GProRecommendsV2Feed gProRecommendsV2Feed) {
        this.mInfo = gProRecommendsV2Feed;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendsV2Feed
    public ArrayList<String> getAttributeTags() {
        return this.mInfo.getAttributeTags();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendsV2Feed
    public String getBannerUrl() {
        return this.mInfo.getBannerUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendsV2Feed
    public String getButtonColor() {
        return this.mInfo.getButtonColor();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendsV2Feed
    public String getButtonDesc() {
        return this.mInfo.getButtonDesc();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendsV2Feed
    public String getButtonDescColor() {
        return this.mInfo.getButtonDescColor();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendsV2Feed
    public String getCardBottomColor() {
        return this.mInfo.getCardBottomColor();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendsV2Feed
    public long getCardId() {
        return this.mInfo.getCardId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendsV2Feed
    public long getCardTank() {
        return this.mInfo.getCardTank();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendsV2Feed
    public String getCardUrl() {
        return this.mInfo.getCardUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendsV2Feed
    public long getChannelId() {
        return this.mInfo.getChannelId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendsV2Feed
    public String getChannelInfoColor() {
        return this.mInfo.getChannelInfoColor();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendsV2Feed
    public String getContentId() {
        return this.mInfo.getContentId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendsV2Feed
    public long getCreateTime() {
        return this.mInfo.getCreateTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendsV2Feed
    public int getFavorCnt() {
        return this.mInfo.getFavorCnt();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendsV2Feed
    public int getFeedCardType() {
        return this.mInfo.getFeedCardType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendsV2Feed
    public String getFeedCoverUrl() {
        return this.mInfo.getFeedCoverUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendsV2Feed
    public String getFeedId() {
        return this.mInfo.getFeedId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendsV2Feed
    public String getFeedSubTitle() {
        return this.mInfo.getFeedSubTitle();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendsV2Feed
    public String getFeedTitle() {
        return this.mInfo.getFeedTitle();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendsV2Feed
    public String getFeedVideoCoverUrl() {
        return this.mInfo.getFeedVideoCoverUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendsV2Feed
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendsV2Feed
    public int getImageRatioType() {
        return this.mInfo.getImageRatioType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendsV2Feed
    public String getInviteCode() {
        return this.mInfo.getInviteCode();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendsV2Feed
    public int getIsMore() {
        return this.mInfo.getIsMore();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendsV2Feed
    public long getPosterTinyId() {
        return this.mInfo.getPosterTinyId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendsV2Feed
    public String getTitleColor() {
        return this.mInfo.getTitleColor();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendsV2Feed
    public String toString() {
        return this.mInfo.toString();
    }
}
