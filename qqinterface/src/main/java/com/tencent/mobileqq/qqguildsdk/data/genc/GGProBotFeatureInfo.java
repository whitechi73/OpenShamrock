package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProBotFeatureInfo;

public  class GGProBotFeatureInfo implements IGProBotFeatureInfo {
    public final GProBotFeatureInfo mInfo;

    public GGProBotFeatureInfo(GProBotFeatureInfo gProBotFeatureInfo) {
        this.mInfo = gProBotFeatureInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBotFeatureInfo
    public String getAvailableRangeDesc() {
        return this.mInfo.getAvailableRangeDesc();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBotFeatureInfo
    public String getDesc() {
        return this.mInfo.getDesc();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBotFeatureInfo
    public int getId() {
        return this.mInfo.getId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBotFeatureInfo
    public long getMark() {
        return this.mInfo.getMark();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBotFeatureInfo
    public String getName() {
        return this.mInfo.getName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBotFeatureInfo
    public int getStatus() {
        return this.mInfo.getStatus();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBotFeatureInfo
    public int getType() {
        return this.mInfo.getType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBotFeatureInfo
    public String getUrl() {
        return this.mInfo.getUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBotFeatureInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
