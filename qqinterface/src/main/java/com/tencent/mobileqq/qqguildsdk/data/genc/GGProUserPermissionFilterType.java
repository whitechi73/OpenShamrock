package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public  @interface GGProUserPermissionFilterType {
    public static final int USER_PERMISSION_FILTER_ACTIVITY = 32;
    public static final int USER_PERMISSION_FILTER_EDIT = 16;
    public static final int USER_PERMISSION_FILTER_HANDUP = 64;
    public static final int USER_PERMISSION_FILTER_LIVE = 2;
    public static final int USER_PERMISSION_FILTER_LIVE_OTHER = 8;
    public static final int USER_PERMISSION_FILTER_SPEAK = 4;
}
