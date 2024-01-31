package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public  @interface GGProAppIDEnum {
    public static final int GUILD_JOIN_GUEST_DM = 3;
    public static final int GUILD_JOIN_GUEST_PROFILE = 2;
    public static final int GUILD_JOIN_QQ_FRIEND = 1;
    public static final int UNKOWN = 0;
}
