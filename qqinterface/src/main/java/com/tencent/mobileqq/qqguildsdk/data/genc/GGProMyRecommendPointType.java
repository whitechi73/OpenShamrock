package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public  @interface GGProMyRecommendPointType {
    public static final int DISCOVERY_MY = 0;
    public static final int DISCOVERY_RECOMMEND = 2;
}
