package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProRecommendGameInfo extends Serializable {
    String getIcon();

    int getId();

    IGProRecommendModeInfo getModeInfo();

    String getName();

    String toString();
}
