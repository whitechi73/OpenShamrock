package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernel.nativeinterface.GProDailyRecommendPush;


public class GGProDailyRecommendPush implements IGProDailyRecommendPush {
    public final GProDailyRecommendPush mInfo;

    public GGProDailyRecommendPush(GProDailyRecommendPush gProDailyRecommendPush) {
        this.mInfo = gProDailyRecommendPush;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProDailyRecommendPush
    public String getAvatar() {
        return this.mInfo.getAvatar();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProDailyRecommendPush
    public String getJumpLink() {
        return this.mInfo.getJumpLink();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProDailyRecommendPush
    public String getSubTitle() {
        return this.mInfo.getSubTitle();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProDailyRecommendPush
    public String getTitle() {
        return this.mInfo.getTitle();
    }
}
