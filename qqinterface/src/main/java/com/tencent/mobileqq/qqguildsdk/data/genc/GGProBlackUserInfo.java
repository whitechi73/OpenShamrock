package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProBlackUserInfo;

public  class GGProBlackUserInfo implements IGProBlackUserInfo {
    public final GProBlackUserInfo mInfo;

    public GGProBlackUserInfo(GProBlackUserInfo gProBlackUserInfo) {
        this.mInfo = gProBlackUserInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBlackUserInfo
    public String getAvatarUrl() {
        return this.mInfo.getAvatarUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBlackUserInfo
    public String getNickName() {
        return this.mInfo.getNickName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBlackUserInfo
    public long getTinyId() {
        return this.mInfo.getTinyId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBlackUserInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
