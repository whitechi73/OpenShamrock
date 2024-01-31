package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;

public  interface IGProFetchRecommendChannelRsp extends Serializable {
    long getChannelId();

    String getChannelName();

    String getGuildCoverUrl();

    String getGuildIcon();

    long getGuildId();

    String getGuildName();

    String getGuildProfile();
}
