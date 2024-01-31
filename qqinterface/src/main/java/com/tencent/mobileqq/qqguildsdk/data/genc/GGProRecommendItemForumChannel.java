package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProRecommendItemForumChannel;

public  class GGProRecommendItemForumChannel implements IGProRecommendItemForumChannel {
    public final GProRecommendItemForumChannel mInfo;

    public GGProRecommendItemForumChannel(GProRecommendItemForumChannel gProRecommendItemForumChannel) {
        this.mInfo = gProRecommendItemForumChannel;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendItemForumChannel
    public int getEndColor() {
        return this.mInfo.getEndColor();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendItemForumChannel
    public int getHotFeedNum() {
        return this.mInfo.getHotFeedNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendItemForumChannel
    public String getHotIcon() {
        return this.mInfo.getHotIcon();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendItemForumChannel
    public int getHotValue() {
        return this.mInfo.getHotValue();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendItemForumChannel
    public String getHotValueTitle() {
        return this.mInfo.getHotValueTitle();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendItemForumChannel
    public int getIndex() {
        return this.mInfo.getIndex();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendItemForumChannel
    public String getInviteCode() {
        return this.mInfo.getInviteCode();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendItemForumChannel
    public int getStartColor() {
        return this.mInfo.getStartColor();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendItemForumChannel
    public int getType() {
        return this.mInfo.getType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendItemForumChannel
    public String toString() {
        return this.mInfo.toString();
    }
}
