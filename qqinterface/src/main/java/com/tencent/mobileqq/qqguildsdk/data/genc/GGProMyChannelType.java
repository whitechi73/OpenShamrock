package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public  @interface GGProMyChannelType {
    public static final int ADD_MY_CHANNEL_LIST = 1;
    public static final int INVALID = 0;
    public static final int UPDATE_SEQ = 2;
}
