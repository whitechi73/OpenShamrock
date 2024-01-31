package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public  @interface GGProGiftSendType {
    public static final int BIRTH_TYPE = 1;
    public static final int FREE_PACK_TYPE = 3;
    public static final int NORMAL_TYPE = 0;
    public static final int PAID_PACK_TYPE = 2;
}
