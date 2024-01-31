package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProRecommendModeInfo extends Serializable {
    boolean getIsPK();

    int getModeId();

    String getModeName();

    int getPlayerNum();

    String toString();
}
