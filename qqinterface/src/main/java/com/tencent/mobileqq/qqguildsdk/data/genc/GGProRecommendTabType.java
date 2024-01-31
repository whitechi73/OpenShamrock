package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public  @interface GGProRecommendTabType {
    public static final int DEFAULT = 0;
    public static final int HOT = 2;
    public static final int MY = 1;
    public static final int RECOMMEND = 3;
}
