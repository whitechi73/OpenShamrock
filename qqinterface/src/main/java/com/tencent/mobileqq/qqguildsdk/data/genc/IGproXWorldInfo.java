package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;


public  interface IGproXWorldInfo extends Serializable {
    boolean getAllowDisplay();

    long getBindTime();

    long getGuildId();

    String getGuildName();

    String getGuildUrl();

    String toString();
}
