package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public  @interface GGProGuildNumberStatus {
    public static final int STATUS_CAN_EDIT = 0;
    public static final int STATUS_CAN_NOT_EDIT = 2;
    public static final int STATUS_IN_REVIEW = 1;
}
