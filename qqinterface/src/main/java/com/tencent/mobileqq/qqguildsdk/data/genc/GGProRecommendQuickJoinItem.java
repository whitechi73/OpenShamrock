package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProRecommendQuickJoinItem;

public  class GGProRecommendQuickJoinItem implements IGProRecommendQuickJoinItem {
    public final GProRecommendQuickJoinItem mInfo;

    public GGProRecommendQuickJoinItem(GProRecommendQuickJoinItem gProRecommendQuickJoinItem) {
        this.mInfo = gProRecommendQuickJoinItem;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendQuickJoinItem
    public long getChannelId() {
        return this.mInfo.getChannelId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendQuickJoinItem
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendQuickJoinItem
    public String getJoinSig() {
        return this.mInfo.getJoinSig();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendQuickJoinItem
    public String getMainSource() {
        return this.mInfo.getMainSource();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendQuickJoinItem
    public String getSubSource() {
        return this.mInfo.getSubSource();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendQuickJoinItem
    public String toString() {
        return this.mInfo.toString();
    }
}
