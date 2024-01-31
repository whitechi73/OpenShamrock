package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public  @interface GGProConvertThirdIdType {
    public static final int GROUPID_TO_OPENGROUPID = 6;
    public static final int GUILDID_TO_OPENGUILDID = 0;
    public static final int OPENGROUPID_TO_GROUPID = 7;
    public static final int OPENGROUPUSERID_TO_UIN = 9;
    public static final int OPENGUILDID_TO_GUILDID = 1;
    public static final int OPENUSERID_TO_UIN = 5;
    public static final int OPENUSERID_TO_USERTINYID = 3;
    public static final int UIN_TO_OPENGROUPUSERID = 8;
    public static final int UIN_TO_OPENUSERID = 4;
    public static final int USERTINYID_TO_OPENUSERID = 2;
}
