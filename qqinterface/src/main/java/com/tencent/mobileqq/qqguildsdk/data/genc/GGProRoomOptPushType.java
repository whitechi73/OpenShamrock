package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public  @interface GGProRoomOptPushType {
    public static final int ROOM_OPT_PUSH_ADDUP = 1;
    public static final int ROOM_OPT_PUSH_DEL = 2;
    public static final int ROOM_OPT_PUSH_UNKNOWN = 0;
    public static final int ROOM_OPT_SWITCH = 3;
}
