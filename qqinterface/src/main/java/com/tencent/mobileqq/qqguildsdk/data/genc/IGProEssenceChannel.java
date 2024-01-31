package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProEssenceChannel extends Serializable {
    long getChannelId();

    int getChannelType();

    String getRecommend();

    String toString();
}
