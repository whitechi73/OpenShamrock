package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProPrefetchRecommendBubbleInfo;

/* loaded from: classes33.dex */
public class GGProPrefetchRecommendBubbleInfo implements IGProPrefetchRecommendBubbleInfo {
    public final GProPrefetchRecommendBubbleInfo mInfo;

    public GGProPrefetchRecommendBubbleInfo(GProPrefetchRecommendBubbleInfo gProPrefetchRecommendBubbleInfo) {
        this.mInfo = gProPrefetchRecommendBubbleInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPrefetchRecommendBubbleInfo
    public boolean getIsDisplay() {
        return this.mInfo.getIsDisplay();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPrefetchRecommendBubbleInfo
    public String getTips() {
        return this.mInfo.getTips();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPrefetchRecommendBubbleInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
