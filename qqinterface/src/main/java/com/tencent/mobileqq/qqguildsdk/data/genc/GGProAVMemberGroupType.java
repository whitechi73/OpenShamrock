package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public  @interface GGProAVMemberGroupType {
    public static final int PLAYERS = 1;
    public static final int UNKNOWN = 0;
    public static final int VIEWERS = 2;
}
