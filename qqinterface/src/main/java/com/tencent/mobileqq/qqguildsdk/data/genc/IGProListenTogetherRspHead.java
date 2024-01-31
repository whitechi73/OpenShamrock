package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProListenTogetherRspHead extends Serializable {
    IGProConfirmOption getConfirmOption();

    int getModCode();

    String toString();
}
