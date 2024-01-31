package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProSubscribeUserGuide extends Serializable {
    String getAvatar();

    String getCover();

    long getGuildId();

    String getGuildName();

    String getProfile();

    String toString();
}
