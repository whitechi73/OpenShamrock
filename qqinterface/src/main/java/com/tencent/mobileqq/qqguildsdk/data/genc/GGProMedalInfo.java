package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProMedalInfo;


public class GGProMedalInfo implements IGProMedalInfo {
    public final GProMedalInfo mInfo;

    public GGProMedalInfo(GProMedalInfo gProMedalInfo) {
        this.mInfo = gProMedalInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedalInfo
    public long getExpireTime() {
        return this.mInfo.getExpireTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedalInfo
    public String getIconUrl() {
        return this.mInfo.getIconUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedalInfo
    public String getName() {
        return this.mInfo.getName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedalInfo
    public IGProOfficialMedalInfoExt getOfficialMedalInfoExt() {
        return new GGProOfficialMedalInfoExt(this.mInfo.getOfficialMedalInfoExt());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedalInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
