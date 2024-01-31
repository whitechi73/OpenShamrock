package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProMsgTimeRange extends Serializable {
    String getEndDate();

    String getStartDate();

    String toString();
}
