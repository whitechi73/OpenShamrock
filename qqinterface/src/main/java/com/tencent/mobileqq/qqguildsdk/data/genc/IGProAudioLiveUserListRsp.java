package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.mobileqq.qqguildsdk.data.IAudioChannelMemberInfos;

import java.io.Serializable;

public  interface IGProAudioLiveUserListRsp extends Serializable {
    IAudioChannelMemberInfos getChannelMemberInfo();

    IGProChannelUserNum getChannelUserNum();

    IAudioChannelMemberInfos getHandUpMemberInfo();

    boolean getIsEndPage();

    long getNextReadInterval();

    IAudioChannelMemberInfos getSpeakOrderMemberInfo();

    String toString();
}
