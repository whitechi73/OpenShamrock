package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProGuildNumInfo;

public  class GGProGuildNumInfo implements IGProGuildNumInfo {
    public final GProGuildNumInfo mInfo;

    public GGProGuildNumInfo(GProGuildNumInfo gProGuildNumInfo) {
        this.mInfo = gProGuildNumInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildNumInfo
    public long getLeftTime() {
        return this.mInfo.getLeftTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildNumInfo
    public String getName() {
        return this.mInfo.getName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildNumInfo
    public int getStatus() {
        return this.mInfo.getStatus();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildNumInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
