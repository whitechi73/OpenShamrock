package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public  @interface GGProVoiceSpeakModeEnum {
    public static final int NONE = 0;
    public static final int SPEAK_MODE_FREE = 1;
    public static final int SPEAK_MODE_GAME = 3;
    public static final int SPEAK_MODE_HAND = 4;
    public static final int SPEAK_MODE_QUEUE = 2;
}
