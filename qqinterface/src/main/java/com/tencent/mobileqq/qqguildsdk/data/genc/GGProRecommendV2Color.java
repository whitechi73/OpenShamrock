package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProRecommendV2Color;

/* loaded from: classes33.dex */
public class GGProRecommendV2Color implements IGProRecommendV2Color {
    public final GProRecommendV2Color mInfo;

    public GGProRecommendV2Color(GProRecommendV2Color gProRecommendV2Color) {
        this.mInfo = gProRecommendV2Color;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendV2Color
    public int getUint32B() {
        return this.mInfo.getUint32B();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendV2Color
    public int getUint32G() {
        return this.mInfo.getUint32G();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendV2Color
    public int getUint32R() {
        return this.mInfo.getUint32R();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendV2Color
    public String toString() {
        return this.mInfo.toString();
    }
}
