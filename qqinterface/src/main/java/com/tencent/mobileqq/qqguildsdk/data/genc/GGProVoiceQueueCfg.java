package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProVoiceQueueCfg;


public class GGProVoiceQueueCfg implements IGProVoiceQueueCfg {
    public final GProVoiceQueueCfg mInfo;

    public GGProVoiceQueueCfg(GProVoiceQueueCfg gProVoiceQueueCfg) {
        this.mInfo = gProVoiceQueueCfg;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceQueueCfg
    public int getVoiceQueueState() {
        return this.mInfo.getVoiceQueueState();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceQueueCfg
    public String toString() {
        return this.mInfo.toString();
    }
}
