package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;
import java.util.ArrayList;


public interface IGProPollingData extends Serializable {
    long getChannelId();

    byte[] getCookie();

    //ArrayList<ew> getFeedMsgAbstracts();

    boolean getForcePolling();

    long getGuildId();

    ArrayList<IGProStickyChannel> getGuildStickyChannelList();

    IGProLiveResultItem getLiveResultItem();

    //ArrayList<ew> getMsgAbstracts();

    int getType();

    long getUpdateTime();

    long getVersion();

    IAudioChannelMemberInfos getVoiceChannel();
}
