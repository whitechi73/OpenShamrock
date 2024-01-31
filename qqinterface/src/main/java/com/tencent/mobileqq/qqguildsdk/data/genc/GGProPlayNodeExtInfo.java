package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProPlayNodeExtInfo;

public  class GGProPlayNodeExtInfo implements IGProPlayNodeExtInfo {
    public final GProPlayNodeExtInfo mInfo;

    public GGProPlayNodeExtInfo(GProPlayNodeExtInfo gProPlayNodeExtInfo) {
        this.mInfo = gProPlayNodeExtInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPlayNodeExtInfo
    public long getCompereTinyid() {
        return this.mInfo.getCompereTinyid();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPlayNodeExtInfo
    public boolean getEnableVolume() {
        return this.mInfo.getEnableVolume();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPlayNodeExtInfo
    public int getPauseDuration() {
        return this.mInfo.getPauseDuration();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPlayNodeExtInfo
    public int getPlayState() {
        return this.mInfo.getPlayState();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPlayNodeExtInfo
    public IGProPlayPushScene getPushScene() {
        return new GGProPlayPushScene(this.mInfo.getPushScene());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPlayNodeExtInfo
    public long getSourceNum() {
        return this.mInfo.getSourceNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPlayNodeExtInfo
    public long getStartPlayTime() {
        return this.mInfo.getStartPlayTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPlayNodeExtInfo
    public int getVolume() {
        return this.mInfo.getVolume();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPlayNodeExtInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
