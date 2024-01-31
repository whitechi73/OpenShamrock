package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProUserFreeGiftInfoRsp;

import java.util.ArrayList;

public  class GGProUserFreeGiftInfoRsp implements IGProUserFreeGiftInfoRsp {
    public final GProUserFreeGiftInfoRsp mInfo;

    public GGProUserFreeGiftInfoRsp(GProUserFreeGiftInfoRsp gProUserFreeGiftInfoRsp) {
        this.mInfo = gProUserFreeGiftInfoRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserFreeGiftInfoRsp
    public String getCheckContext() {
        return this.mInfo.getCheckContext();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserFreeGiftInfoRsp
    public int getCountdownSecond() {
        return this.mInfo.getCountdownSecond();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserFreeGiftInfoRsp
    public int getCurrFreeGiftNum() {
        return this.mInfo.getCurrFreeGiftNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserFreeGiftInfoRsp
    public int getDayFreeGiftNum() {
        return this.mInfo.getDayFreeGiftNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserFreeGiftInfoRsp
    public ArrayList<Long> getFreeGiftIds() {
        return this.mInfo.getFreeGiftIds();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserFreeGiftInfoRsp
    public int getGotFreeGiftNum() {
        return this.mInfo.getGotFreeGiftNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserFreeGiftInfoRsp
    public int getMaxFreeGiftNum() {
        return this.mInfo.getMaxFreeGiftNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserFreeGiftInfoRsp
    public ArrayList<Integer> getNeedCheckThemeTypes() {
        return this.mInfo.getNeedCheckThemeTypes();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserFreeGiftInfoRsp
    public long getNextCheckTimeMS() {
        return this.mInfo.getNextCheckTimeMS();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserFreeGiftInfoRsp
    public int getReminderFreeGiftNum() {
        return this.mInfo.getReminderFreeGiftNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserFreeGiftInfoRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
