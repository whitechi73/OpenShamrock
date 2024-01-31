package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProGuildActiveValue;

public  class GGProGuildActiveValue implements IGProGuildActiveValue {
    public final GProGuildActiveValue mInfo;

    public GGProGuildActiveValue(GProGuildActiveValue gProGuildActiveValue) {
        this.mInfo = gProGuildActiveValue;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildActiveValue
    public int getGuildTodayAddActive() {
        return this.mInfo.getGuildTodayAddActive();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildActiveValue
    public int getMyTodayActive() {
        return this.mInfo.getMyTodayActive();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildActiveValue
    public long getTotalGuildActive() {
        return this.mInfo.getTotalGuildActive();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildActiveValue
    public String toString() {
        return this.mInfo.toString();
    }
}
