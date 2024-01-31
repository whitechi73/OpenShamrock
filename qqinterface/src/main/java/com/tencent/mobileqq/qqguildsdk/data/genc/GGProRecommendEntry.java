package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProRecommendEntry;

public  class GGProRecommendEntry implements IGProRecommendEntry {
    public final GProRecommendEntry mInfo;

    public GGProRecommendEntry(GProRecommendEntry gProRecommendEntry) {
        this.mInfo = gProRecommendEntry;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendEntry
    public String getKey() {
        return this.mInfo.getKey();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendEntry
    public byte[] getValue() {
        return this.mInfo.getValue();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendEntry
    public String toString() {
        return this.mInfo.toString();
    }
}
