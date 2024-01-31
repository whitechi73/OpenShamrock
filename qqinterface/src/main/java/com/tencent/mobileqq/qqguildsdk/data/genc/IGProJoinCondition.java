package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProJoinCondition extends Serializable {
    IGProAccountCondition getAccountCondition();

    String toString();
}
