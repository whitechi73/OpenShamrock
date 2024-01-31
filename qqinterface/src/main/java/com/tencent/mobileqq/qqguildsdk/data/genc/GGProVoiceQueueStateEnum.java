package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public  @interface GGProVoiceQueueStateEnum {
    public static final int NONE = 0;
    public static final int QUEUE_START = 1;
    public static final int QUEUE_STOP = 2;
}
