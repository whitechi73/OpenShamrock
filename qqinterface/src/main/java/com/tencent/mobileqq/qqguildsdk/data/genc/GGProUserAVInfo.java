package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProUserAVInfo;

public  class GGProUserAVInfo implements IGProUserAVInfo {
    public final GProUserAVInfo mInfo;

    public GGProUserAVInfo(GProUserAVInfo gProUserAVInfo) {
        this.mInfo = gProUserAVInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserAVInfo
    public IGProSpeakTimeCtl getSpeakTimeCtl() {
        return new GGProSpeakTimeCtl(this.mInfo.getSpeakTimeCtl());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserAVInfo
    public int getUserAVState() {
        return this.mInfo.getUserAVState();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserAVInfo
    public IGProUserDevState getUserDevState() {
        return new GGProUserDevState(this.mInfo.getUserDevState());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserAVInfo
    public boolean getUserInSpeakQueue() {
        return this.mInfo.getUserInSpeakQueue();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserAVInfo
    public boolean getUserIsHandUp() {
        return this.mInfo.getUserIsHandUp();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProUserAVInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
