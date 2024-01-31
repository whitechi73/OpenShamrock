package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public  @interface GGProGlobalPrivacySwitchValue {
    public static final int ALLOW = 2;
    public static final int NOT_ALLOW = 1;
    public static final int STATUS_UNKNOWN = 0;
}
