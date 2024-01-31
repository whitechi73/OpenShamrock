package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProTextMedalInfo;

public  class GGProTextMedalInfo implements IGProTextMedalInfo {
    public final GProTextMedalInfo mInfo;

    public GGProTextMedalInfo(GProTextMedalInfo gProTextMedalInfo) {
        this.mInfo = gProTextMedalInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProTextMedalInfo
    public int getColorBg() {
        return this.mInfo.getColorBg();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProTextMedalInfo
    public int getColorText() {
        return this.mInfo.getColorText();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProTextMedalInfo
    public long getExpireTime() {
        return this.mInfo.getExpireTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProTextMedalInfo
    public String getName() {
        return this.mInfo.getName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProTextMedalInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
