package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProDiscoverStatus extends Serializable {
    int getNextTs();

    int getState();

    int getType();

    String toString();
}
