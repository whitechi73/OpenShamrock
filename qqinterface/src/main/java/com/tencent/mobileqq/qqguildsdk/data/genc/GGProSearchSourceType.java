package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public  @interface GGProSearchSourceType {
    public static final int SOURCE_TYPE_GROUP = 4;
    public static final int SOURCE_TYPE_GUILD = 1;
    public static final int SOURCE_TYPE_GUILD_NUM = 5;
    public static final int SOURCE_TYPE_NEW_DISCOVER = 7;
    public static final int SOURCE_TYPE_PC = 6;
    public static final int SOURCE_TYPE_UNIFY = 2;
    public static final int SOURCE_TYPE_UNKNOWN = 0;
    public static final int SOURCE_TYPE_WEB = 3;
}
