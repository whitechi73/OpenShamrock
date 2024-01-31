package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProOfficialMedalInfoExt;

public  class GGProOfficialMedalInfoExt implements IGProOfficialMedalInfoExt {
    public final GProOfficialMedalInfoExt mInfo;

    public GGProOfficialMedalInfoExt(GProOfficialMedalInfoExt gProOfficialMedalInfoExt) {
        this.mInfo = gProOfficialMedalInfoExt;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProOfficialMedalInfoExt
    public String getIconUrl() {
        return this.mInfo.getIconUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProOfficialMedalInfoExt
    public boolean getIsOffical() {
        return this.mInfo.getIsOffical();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProOfficialMedalInfoExt
    public String toString() {
        return this.mInfo.toString();
    }
}
