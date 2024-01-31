package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProBotInfo;

public  class GGProBotInfo implements IGProBotInfo {
    public final GProBotInfo mInfo;

    public GGProBotInfo(GProBotInfo gProBotInfo) {
        this.mInfo = gProBotInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBotInfo
    public long getAppid() {
        return this.mInfo.getAppid();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBotInfo
    public int getInlineSearch() {
        return this.mInfo.getInlineSearch();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBotInfo
    public long getMark() {
        return this.mInfo.getMark();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBotInfo
    public String getName() {
        return this.mInfo.getName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBotInfo
    public long getTinyid() {
        return this.mInfo.getTinyid();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBotInfo
    public long getUin() {
        return this.mInfo.getUin();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBotInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
