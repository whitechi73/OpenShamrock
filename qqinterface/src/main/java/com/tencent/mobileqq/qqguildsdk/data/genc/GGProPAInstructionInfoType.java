package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public  @interface GGProPAInstructionInfoType {
    public static final int LOGOUT = 2;
    public static final int OPENURL = 3;
    public static final int PRELOGOUT = 8;
    public static final int STOP = 7;
    public static final int TIPS = 1;
    public static final int UNDEFINED = 0;
    public static final int USERDEFINED = 4;
}
