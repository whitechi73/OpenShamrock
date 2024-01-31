package com.tencent.mobileqq.qqguildsdk.data;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Retention(RetentionPolicy.SOURCE)
public  @interface INavigationJumpUrlType {
    public static final int CHANNEL_LINK = 4;
    public static final int FEED_LINK = 5;
    public static final int GUILD_LINK = 3;
    public static final int MINI_PROGRAM = 2;
    public static final int ROBOT = 1;
    public static final int SCHEME_LINK = 6;
    public static final int TEXT_HIDE_GUEST_STATUS = 7;
}
