package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProVoiceSpeakModeCfg;


public class GGProVoiceSpeakModeCfg implements IGProVoiceSpeakModeCfg {
    public final GProVoiceSpeakModeCfg mInfo;

    public GGProVoiceSpeakModeCfg(GProVoiceSpeakModeCfg gProVoiceSpeakModeCfg) {
        this.mInfo = gProVoiceSpeakModeCfg;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSpeakModeCfg
    public int getSpeakMode() {
        return this.mInfo.getSpeakMode();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSpeakModeCfg
    public int getSpeakSecond() {
        return this.mInfo.getSpeakSecond();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSpeakModeCfg
    public String toString() {
        return this.mInfo.toString();
    }
}
