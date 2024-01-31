package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProBlackUserInfo extends Serializable {
    String getAvatarUrl();

    String getNickName();

    long getTinyId();

    String toString();
}
