package com.tencent.mobileqq.qqguildsdk.data;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Retention(RetentionPolicy.SOURCE)
public  @interface IMsgRevokeType {
    public static final int ALL_TIME = 5;
    public static final int FIFTEEN_DAYS = 3;
    public static final int SEVEN_DAYS = 2;
    public static final int THIRTY_DAYS = 4;
    public static final int THREE_DAYS = 1;
    public static final int UNSPECIFIED = 0;
}
