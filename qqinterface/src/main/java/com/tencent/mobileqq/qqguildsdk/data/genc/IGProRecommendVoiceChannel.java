package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.mobileqq.qqguildsdk.data.IAudioChannelMemberInfos;

import java.io.Serializable;

public  interface IGProRecommendVoiceChannel extends Serializable {
    IGProRecommendCoverInfo getCover();

    IAudioChannelMemberInfos getVoiceChannel();

    String toString();
}
