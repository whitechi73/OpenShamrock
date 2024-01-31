package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public  @interface GGProActiveUserStateType {
    public static final int STATE_TYPE_FEED_CHANNEL = 105;
    public static final int STATE_TYPE_LIVE_CHANNEL = 102;
    public static final int STATE_TYPE_MINI_GAME = 18;
    public static final int STATE_TYPE_MUSIC_PLAY = 17;
    public static final int STATE_TYPE_NEW_SMOBA = 9;
    public static final int STATE_TYPE_ON_SCREEN_SHARE = 6;
    public static final int STATE_TYPE_ON_VOICE = 4;
    public static final int STATE_TYPE_TEXT_CHANNEL = 104;
    public static final int STATE_TYPE_UNKNOWN = 0;
}
