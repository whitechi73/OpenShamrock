package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProLiveRoomInfo;

import java.io.Serializable;


public interface IGProStickyChannel extends Serializable {
    String getChannelId();

    int getChannelType();

    long getCreateTime();

    IGProStickyFeedChannel getFeedChannel();

    String getGuildId();

    IGProLiveRoomInfo getLiveChannel();

    IGProStickyTextChannel getTextChannel();

    long getUpdateTime();

    IAudioChannelMemberInfos getVoiceChannel();
}
