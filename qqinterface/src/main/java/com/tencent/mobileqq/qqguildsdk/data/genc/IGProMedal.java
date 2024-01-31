package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;


public interface IGProMedal extends Serializable {
    String getDesc();

    long getEndTime();

    long getStartTime();

    String getUrl();

    String toString();
}
