package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProForumChannel extends Serializable {
    long getChannelId();

    String getChannelName();

    long getEndColor();

    String getGuildFaceUrl();

    long getGuildId();

    String getGuildName();

    String getHotValueTitle();

    int getIndex();

    String getJoinSign();

    long getStartColor();

    int getType();

    String toString();
}
