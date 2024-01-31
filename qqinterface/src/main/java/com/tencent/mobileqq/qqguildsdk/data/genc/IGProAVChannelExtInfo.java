package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProAVChannelExtInfo extends Serializable {
    int getAllowOtherRaiseHand();

    int getChannelMaxMember();

    IGProInviteSpeakCfg getInviteSpeakCfg();

    int getNoMemberMaxLimited();

    IGProVoiceQueueCfg getVoiceQueueCfg();

    IGProVoiceSpeakModeCfg getVoiceSpeakModeCfg();

    String toString();
}
