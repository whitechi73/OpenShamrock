package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public  @interface GGProDiscoverState {
    public static final int INTERACTIVE = 10;
    public static final int LISTENING = 11;
    public static final int LIVE = 1;
    public static final int MINI_GAME = 30;
    public static final int NONE = 0;
    public static final int SCREEN_SHARE = 6;
    public static final int SMOBA = 9;
    public static final int VOICE = 4;
}
