package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProGetRedPointRsp extends Serializable {
    String getAvatar();

    int getBusinessType();

    long getChannelId();

    long getGuildId();

    boolean getHasRedPoint();

    String getIconUrl();

    boolean getIsJoinGuild();

    String getTransBuffer();

    int getWatchCycle();

    String toString();
}
