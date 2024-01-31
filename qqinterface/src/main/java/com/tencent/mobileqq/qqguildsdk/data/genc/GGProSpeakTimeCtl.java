package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProSpeakTimeCtl;

public  class GGProSpeakTimeCtl implements IGProSpeakTimeCtl {
    public final GProSpeakTimeCtl mInfo;

    public GGProSpeakTimeCtl(GProSpeakTimeCtl gProSpeakTimeCtl) {
        this.mInfo = gProSpeakTimeCtl;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSpeakTimeCtl
    public int getQueueSpeakS() {
        return this.mInfo.getQueueSpeakS();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSpeakTimeCtl
    public long getStartSpeakMs() {
        return this.mInfo.getStartSpeakMs();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSpeakTimeCtl
    public long getStopSpeakMs() {
        return this.mInfo.getStopSpeakMs();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSpeakTimeCtl
    public String toString() {
        return this.mInfo.toString();
    }
}
