package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProSwitchInfo extends Serializable {
    int getCloseReason();

    int getSwitchState();

    int getSwitchType();

    String toString();
}
