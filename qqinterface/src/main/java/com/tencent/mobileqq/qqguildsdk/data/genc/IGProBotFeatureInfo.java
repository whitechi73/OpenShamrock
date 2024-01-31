package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProBotFeatureInfo extends Serializable {
    String getAvailableRangeDesc();

    String getDesc();

    int getId();

    long getMark();

    String getName();

    int getStatus();

    int getType();

    String getUrl();

    String toString();
}
