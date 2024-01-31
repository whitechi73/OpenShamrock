package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public  @interface GGProSwitchCloseReason {
    public static final int IS_BEAT = 1;
    public static final int RESERVE = 0;
}
