package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProRetentionChannelLabel extends Serializable {
    String getLabelName();

    int getLabelType();

    int getLabelValue();

    String toString();
}
