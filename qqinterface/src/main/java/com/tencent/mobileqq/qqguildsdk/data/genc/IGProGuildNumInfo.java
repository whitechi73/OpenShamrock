package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProGuildNumInfo extends Serializable {
    long getLeftTime();

    String getName();

    int getStatus();

    String toString();
}
