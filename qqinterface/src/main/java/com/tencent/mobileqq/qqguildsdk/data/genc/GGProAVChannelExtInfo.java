package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProAVChannelExtInfo;

public  class GGProAVChannelExtInfo implements IGProAVChannelExtInfo {
    public final GProAVChannelExtInfo mInfo;

    public GGProAVChannelExtInfo(GProAVChannelExtInfo gProAVChannelExtInfo) {
        this.mInfo = gProAVChannelExtInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAVChannelExtInfo
    public int getAllowOtherRaiseHand() {
        return this.mInfo.getAllowOtherRaiseHand();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAVChannelExtInfo
    public int getChannelMaxMember() {
        return this.mInfo.getChannelMaxMember();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAVChannelExtInfo
    public IGProInviteSpeakCfg getInviteSpeakCfg() {
        return new GGProInviteSpeakCfg(this.mInfo.getInviteSpeakCfg());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAVChannelExtInfo
    public int getNoMemberMaxLimited() {
        return this.mInfo.getNoMemberMaxLimited();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAVChannelExtInfo
    public IGProVoiceQueueCfg getVoiceQueueCfg() {
        return new GGProVoiceQueueCfg(this.mInfo.getVoiceQueueCfg());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAVChannelExtInfo
    public IGProVoiceSpeakModeCfg getVoiceSpeakModeCfg() {
        return new GGProVoiceSpeakModeCfg(this.mInfo.getVoiceSpeakModeCfg());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAVChannelExtInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
