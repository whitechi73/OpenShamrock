package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public  @interface GGProDiscoverySceneType {
    public static final int DEFAULT = 0;
    public static final int MY_REMAINDER = 1;
    public static final int PREFETCH_RECOMMEND = 2;
    public static final int QUICK_JOIN = 4;
    public static final int TOP_RECOMMEND = 3;
}
