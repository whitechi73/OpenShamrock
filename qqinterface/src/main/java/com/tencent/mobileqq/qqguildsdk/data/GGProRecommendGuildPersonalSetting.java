package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernel.nativeinterface.GProRecommendGuildPersonalSetting;


public class GGProRecommendGuildPersonalSetting implements IGProRecommendGuildPersonalSetting {
    public final GProRecommendGuildPersonalSetting mInfo;

    public GGProRecommendGuildPersonalSetting(GProRecommendGuildPersonalSetting gProRecommendGuildPersonalSetting) {
        this.mInfo = gProRecommendGuildPersonalSetting;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProRecommendGuildPersonalSetting
    public int getExitOption() {
        return this.mInfo.getExitOption();
    }
}
