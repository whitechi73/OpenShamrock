package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProGuildActiveValue extends Serializable {
    int getGuildTodayAddActive();

    int getMyTodayActive();

    long getTotalGuildActive();

    String toString();
}
