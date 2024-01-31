package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public  @interface GGProTabExposeFlag {
    public static final int EXPOSE = 0;
    public static final int NO_EXPOSE = 1;
}
