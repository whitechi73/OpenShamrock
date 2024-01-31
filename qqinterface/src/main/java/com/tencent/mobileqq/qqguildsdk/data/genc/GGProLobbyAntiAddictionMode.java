package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public  @interface GGProLobbyAntiAddictionMode {
    public static final int ANTI_ADDICTION_MODE_NORMAL = 0;
    public static final int ANTI_ADDICTION_MODE_ONLY_PLAYING = 1;
}
