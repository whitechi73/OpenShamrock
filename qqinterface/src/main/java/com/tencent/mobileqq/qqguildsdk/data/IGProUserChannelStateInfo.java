package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;


public interface IGProUserChannelStateInfo extends Serializable {
    long getChannelId();

    long getGuildId();

    int getPlatform();

    long getTinyId();

    int getUserState();

    long getUserStateSeq();
}
