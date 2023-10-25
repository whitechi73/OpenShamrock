package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProAVChannelExtInfo implements Serializable {
    int allowOtherRaiseHand;
    int channelMaxMember;
    GProInviteSpeakCfg inviteSpeakCfg;
    int noMemberMaxLimited;
    long serialVersionUID;
    GProVoiceQueueCfg voiceQueueCfg;
    GProVoiceSpeakModeCfg voiceSpeakModeCfg;

    public GProAVChannelExtInfo() {
        this.serialVersionUID = 1L;
        this.voiceSpeakModeCfg = new GProVoiceSpeakModeCfg();
        this.voiceQueueCfg = new GProVoiceQueueCfg();
        this.inviteSpeakCfg = new GProInviteSpeakCfg();
    }

    public int getAllowOtherRaiseHand() {
        return this.allowOtherRaiseHand;
    }

    public int getChannelMaxMember() {
        return this.channelMaxMember;
    }

    public GProInviteSpeakCfg getInviteSpeakCfg() {
        return this.inviteSpeakCfg;
    }

    public int getNoMemberMaxLimited() {
        return this.noMemberMaxLimited;
    }

    public GProVoiceQueueCfg getVoiceQueueCfg() {
        return this.voiceQueueCfg;
    }

    public GProVoiceSpeakModeCfg getVoiceSpeakModeCfg() {
        return this.voiceSpeakModeCfg;
    }

    public void setAllowOtherRaiseHand(int i2) {
        this.allowOtherRaiseHand = i2;
    }

    public void setChannelMaxMember(int i2) {
        this.channelMaxMember = i2;
    }

    public void setInviteSpeakCfg(GProInviteSpeakCfg gProInviteSpeakCfg) {
        this.inviteSpeakCfg = gProInviteSpeakCfg;
    }

    public void setNoMemberMaxLimited(int i2) {
        this.noMemberMaxLimited = i2;
    }

    public void setVoiceQueueCfg(GProVoiceQueueCfg gProVoiceQueueCfg) {
        this.voiceQueueCfg = gProVoiceQueueCfg;
    }

    public void setVoiceSpeakModeCfg(GProVoiceSpeakModeCfg gProVoiceSpeakModeCfg) {
        this.voiceSpeakModeCfg = gProVoiceSpeakModeCfg;
    }

    public String toString() {
        return "GProAVChannelExtInfo{channelMaxMember=" + this.channelMaxMember + ",allowOtherRaiseHand=" + this.allowOtherRaiseHand + ",noMemberMaxLimited=" + this.noMemberMaxLimited + ",voiceSpeakModeCfg=" + this.voiceSpeakModeCfg + ",voiceQueueCfg=" + this.voiceQueueCfg + ",inviteSpeakCfg=" + this.inviteSpeakCfg + ",}";
    }

    public GProAVChannelExtInfo(int i2, int i3, int i4, GProVoiceSpeakModeCfg gProVoiceSpeakModeCfg, GProVoiceQueueCfg gProVoiceQueueCfg, GProInviteSpeakCfg gProInviteSpeakCfg) {
        this.serialVersionUID = 1L;
        this.voiceSpeakModeCfg = new GProVoiceSpeakModeCfg();
        this.voiceQueueCfg = new GProVoiceQueueCfg();
        this.inviteSpeakCfg = new GProInviteSpeakCfg();
        this.channelMaxMember = i2;
        this.allowOtherRaiseHand = i3;
        this.noMemberMaxLimited = i4;
        this.voiceSpeakModeCfg = gProVoiceSpeakModeCfg;
        this.voiceQueueCfg = gProVoiceQueueCfg;
        this.inviteSpeakCfg = gProInviteSpeakCfg;
    }
}
