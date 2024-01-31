package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;


public interface IGProGuildUserState extends Serializable {
    long getChannelId();

    long getGuildId();

    boolean getHasEnteredChannel();

    String toString();
}
