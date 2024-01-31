package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProSubscribeUserGuide;

public  class GGProSubscribeUserGuide implements IGProSubscribeUserGuide {
    public final GProSubscribeUserGuide mInfo;

    public GGProSubscribeUserGuide(GProSubscribeUserGuide gProSubscribeUserGuide) {
        this.mInfo = gProSubscribeUserGuide;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSubscribeUserGuide
    public String getAvatar() {
        return this.mInfo.getAvatar();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSubscribeUserGuide
    public String getCover() {
        return this.mInfo.getCover();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSubscribeUserGuide
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSubscribeUserGuide
    public String getGuildName() {
        return this.mInfo.getGuildName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSubscribeUserGuide
    public String getProfile() {
        return this.mInfo.getProfile();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSubscribeUserGuide
    public String toString() {
        return this.mInfo.toString();
    }
}
