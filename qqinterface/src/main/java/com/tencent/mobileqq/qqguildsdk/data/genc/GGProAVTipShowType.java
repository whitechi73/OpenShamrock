package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public  @interface GGProAVTipShowType {
    public static final int TIP_ALERT = 2;
    public static final int TIP_DEFAULT = 0;
    public static final int TIP_TOAST = 1;
}
