package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public  @interface GGProAdType {
    public static final int CHANNEL = 3;
    public static final int FORUM = 4;
    public static final int GUILD = 2;
    public static final int PICTURE = 1;
    public static final int UNKNOWN_AD_TYPE = 0;
}
