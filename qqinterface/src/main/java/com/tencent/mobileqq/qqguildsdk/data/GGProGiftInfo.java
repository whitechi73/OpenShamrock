package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernel.nativeinterface.GProGiftInfo;

public  class GGProGiftInfo implements IGProGiftInfo {
    public final GProGiftInfo mInfo;

    public GGProGiftInfo(GProGiftInfo gProGiftInfo) {
        this.mInfo = gProGiftInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGiftInfo
    public int getAllComboCnt() {
        return this.mInfo.getAllComboCnt();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGiftInfo
    public boolean getComboOver() {
        return this.mInfo.getComboOver();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGiftInfo
    public long getComboSeq() {
        return this.mInfo.getComboSeq();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGiftInfo
    public int getEffectLevel() {
        return this.mInfo.getEffectLevel();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGiftInfo
    public int getGiftId() {
        return this.mInfo.getGiftId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGiftInfo
    public String getGiftName() {
        return this.mInfo.getGiftName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGiftInfo
    public int getGiftNum() {
        return this.mInfo.getGiftNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGiftInfo
    public long getGiftPrice() {
        return this.mInfo.getGiftPrice();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGiftInfo
    public int getGiftType() {
        return this.mInfo.getGiftType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGiftInfo
    public int getMaterialId() {
        return this.mInfo.getMaterialId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProGiftInfo
    public int getSendType() {
        return this.mInfo.getSendType();
    }
}
