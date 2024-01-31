package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GproXWorldInfo;


public  class GGproXWorldInfo implements IGproXWorldInfo {
    public final GproXWorldInfo mInfo;

    public GGproXWorldInfo(GproXWorldInfo gproXWorldInfo) {
        this.mInfo = gproXWorldInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGproXWorldInfo
    public boolean getAllowDisplay() {
        return this.mInfo.getAllowDisplay();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGproXWorldInfo
    public long getBindTime() {
        return this.mInfo.getBindTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGproXWorldInfo
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGproXWorldInfo
    public String getGuildName() {
        return this.mInfo.getGuildName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGproXWorldInfo
    public String getGuildUrl() {
        return this.mInfo.getGuildUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGproXWorldInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
