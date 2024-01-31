package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProRecommendGuildState;

import java.util.ArrayList;

public  class GGProRecommendGuildState implements IGProRecommendGuildState {
    public final GProRecommendGuildState mInfo;

    public GGProRecommendGuildState(GProRecommendGuildState gProRecommendGuildState) {
        this.mInfo = gProRecommendGuildState;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendGuildState
    public String getDesc() {
        return this.mInfo.getDesc();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendGuildState
    public ArrayList<String> getIconUrls() {
        return this.mInfo.getIconUrls();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendGuildState
    public int getState() {
        return this.mInfo.getState();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendGuildState
    public String toString() {
        return this.mInfo.toString();
    }
}
