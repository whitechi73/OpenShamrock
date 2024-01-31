package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public  @interface GGProPlayState {
    public static final int NO_PLAYED = 3;
    public static final int PAUSING = 2;
    public static final int PLAYED = 4;
    public static final int PLAYING = 1;
    public static final int STOP_PLAY = 5;
    public static final int UNKNOWN_STATE = 0;
}
