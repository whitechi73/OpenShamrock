package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProPrefetchRecommendGuildInfo;

import java.io.Serializable;

/* loaded from: classes33.dex */
public class GGProPrefetchRecommendGuildInfo implements Serializable {
    public final GProPrefetchRecommendGuildInfo mInfo;

    public GGProPrefetchRecommendGuildInfo(GProPrefetchRecommendGuildInfo gProPrefetchRecommendGuildInfo) {
        this.mInfo = gProPrefetchRecommendGuildInfo;
    }

    public String getCategory() {
        return this.mInfo.getCategory();
    }

    public String getGuildIcon() {
        return this.mInfo.getGuildIcon();
    }

    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    public String toString() {
        return this.mInfo.toString();
    }
}
