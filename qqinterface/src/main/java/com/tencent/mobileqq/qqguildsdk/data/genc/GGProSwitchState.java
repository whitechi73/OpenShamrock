package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public  @interface GGProSwitchState {
    public static final int CLOSE = 2;
    public static final int INVALID = 0;
    public static final int OPEN = 1;
}
