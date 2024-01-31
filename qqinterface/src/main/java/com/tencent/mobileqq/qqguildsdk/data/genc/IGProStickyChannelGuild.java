package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProStickyChannelGuild extends Serializable {
    long getGuildId();

    boolean getHasStickyChannel();

    String toString();
}
