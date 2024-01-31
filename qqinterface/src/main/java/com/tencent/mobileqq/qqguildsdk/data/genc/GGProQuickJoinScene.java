package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public  @interface GGProQuickJoinScene {
    public static final int CURRENT_ACTIVITY = 3;
    public static final int EXTENDED_PAGE = 4;
    public static final int HOT_RECOMMEND = 2;
    public static final int MY_RECOMMEND = 1;
    public static final int QUICK_JOIN_SCENE_UNKNOWN = 0;
}
