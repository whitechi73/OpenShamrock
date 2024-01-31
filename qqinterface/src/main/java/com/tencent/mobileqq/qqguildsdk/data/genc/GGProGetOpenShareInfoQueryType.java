package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public  @interface GGProGetOpenShareInfoQueryType {
    public static final int CONVERT = 1;
    public static final int DEFAULT = 0;
    public static final int PARSE = 2;
}
