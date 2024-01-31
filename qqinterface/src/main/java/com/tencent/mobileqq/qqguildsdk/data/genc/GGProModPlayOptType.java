package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public  @interface GGProModPlayOptType {
    public static final int ERROPT = 0;
    public static final int ONE_LOOP = 11;
    public static final int PAUSE = 2;
    public static final int PLAY = 1;
    public static final int PLAY_IN_ORDER = 12;
    public static final int PLAY_NEXT = 4;
    public static final int STOP = 3;
}
