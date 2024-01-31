package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public  @interface GGProGlobalPrivacySwitchType {
    public static final int ADD_QQ_FRIEND = 0;
    public static final int SHOW_JOINED_GUILD = 2;
    public static final int SHOW_PUBLISHED_FEED = 3;
    public static final int SHOW_QQ_PROFILE = 1;
    public static final int SHOW_ROOM_STATE = 4;
}
