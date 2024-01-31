package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.GGProSpeakTimeCtl;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProSpeakTimeCtl;
import com.tencent.qqnt.kernel.nativeinterface.GProUserAVInfo;

public  class GProUserAVData implements IGProUserAVData {
    private GProUserAVInfo mUserAVInfo;

    public GProUserAVData(GProUserAVInfo gProUserAVInfo) {
        this.mUserAVInfo = gProUserAVInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserAVData
    public IGProSpeakTimeCtl getSpeakTimeCtl() {
        return new GGProSpeakTimeCtl(this.mUserAVInfo.getSpeakTimeCtl());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserAVData
    public int getUserAVState() {
        return this.mUserAVInfo.getUserAVState();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserAVData
    public IGProUserDevStateData getUserDevState() {
        return new GProUserDevStateData(this.mUserAVInfo.getUserDevState());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserAVData
    public boolean isUserHandUp() {
        return this.mUserAVInfo.getUserIsHandUp();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserAVData
    public boolean isUserInSpeakQueue() {
        return this.mUserAVInfo.getUserInSpeakQueue();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserAVData
    public void setUserAVState(int i2) {
        this.mUserAVInfo.setUserAVState(i2);
    }
}
