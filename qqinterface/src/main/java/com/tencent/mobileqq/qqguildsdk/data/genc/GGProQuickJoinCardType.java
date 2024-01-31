package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public  @interface GGProQuickJoinCardType {
    public static final int ALL = 1;
    public static final int BLOOD_RED = 5;
    public static final int CHAT_TOGETHER = 7;
    public static final int CLOUD_DANCE = 2;
    public static final int LISTEN_TOGETHER = 8;
    public static final int PLAY_TOGETHER = 9;
    public static final int QUICK_JOIN_TYPE_UNKNOWN = 0;
    public static final int SCREEN_SHARE = 10;
    public static final int SUPER_ANSWER_KING = 6;
    public static final int WEIPAI_WOLF_KILL = 4;
    public static final int WOLF_KILL = 3;
}
