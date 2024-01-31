package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public  @interface GGProProfileShowSwitchType {
    public static final int AUDIO_ROOM_STATE = 1;
    public static final int MY_JOINED_GUILD = 2;
    public static final int MY_POST = 3;
    public static final int UNKNOW_TYPE = 0;
}
