package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public  @interface GGProMedalLevelEnum {
    public static final int LEVEL_ENTERPRISE = 2;
    public static final int LEVEL_PERSONAL = 3;
    public static final int LEVEL_TEST = 1;
    public static final int NONE = 0;
}
