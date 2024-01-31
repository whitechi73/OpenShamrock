package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProAdInfo extends Serializable {
    int getAdId();

    int getAdType();

    String getJumpUrl();

    String getPicUrl();

    String getSubTitle();

    String getTag();

    String getTitle();

    String toString();
}
