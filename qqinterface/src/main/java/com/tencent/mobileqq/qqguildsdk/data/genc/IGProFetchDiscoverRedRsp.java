package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProFetchDiscoverRedRsp extends Serializable {
    int getBusinessType();

    byte[] getCookies();

    IGProDiscoverStatus getDiscoverStatus();

    int getFlag();

    int getPointType();

    long getSeq();

    String toString();
}
