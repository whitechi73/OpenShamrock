package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProAtSetInfo extends Serializable {
    long getGuildId();

    int getRemainingAtAllCount();

    int getRemainingAtOnlCount();

    int getRemainingAtRoleCount();

    int getTotalAtAllCount();

    int getTotalAtOnlCount();

    int getTotalAtRoleCount();

    String toString();
}
