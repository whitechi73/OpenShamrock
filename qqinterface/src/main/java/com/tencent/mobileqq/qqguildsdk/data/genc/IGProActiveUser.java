package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProActiveUser extends Serializable {
    long getAge();

    String getAvatarMeta();

    String getCityName();

    int getGender();

    long getGuildId();

    boolean getIsQQFriend();

    String getNickName();

    String getOpenid();

    long getStateType();

    long getTinyid();

    String toString();
}
