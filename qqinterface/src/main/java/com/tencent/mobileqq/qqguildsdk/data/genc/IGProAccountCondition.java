package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProAccountCondition extends Serializable {
    long getClientId();

    boolean getIsNeedAuth();

    String toString();
}
