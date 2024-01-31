package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProPrefetchRecommendRedDotInfo;

/* loaded from: classes33.dex */
public class GGProPrefetchRecommendRedDotInfo implements IGProPrefetchRecommendRedDotInfo {
    public final GProPrefetchRecommendRedDotInfo mInfo;

    public GGProPrefetchRecommendRedDotInfo(GProPrefetchRecommendRedDotInfo gProPrefetchRecommendRedDotInfo) {
        this.mInfo = gProPrefetchRecommendRedDotInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPrefetchRecommendRedDotInfo
    public boolean getIsDisplay() {
        return this.mInfo.getIsDisplay();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPrefetchRecommendRedDotInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
