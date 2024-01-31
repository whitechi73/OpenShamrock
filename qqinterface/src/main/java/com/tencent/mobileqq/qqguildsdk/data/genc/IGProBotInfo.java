package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProBotInfo extends Serializable {
    long getAppid();

    int getInlineSearch();

    long getMark();

    String getName();

    long getTinyid();

    long getUin();

    String toString();
}
