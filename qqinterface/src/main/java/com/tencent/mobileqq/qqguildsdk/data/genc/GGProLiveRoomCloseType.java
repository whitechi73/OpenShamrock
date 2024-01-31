package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public  @interface GGProLiveRoomCloseType {
    public static final int NORMAL_CLOSE = 0;
    public static final int SECURITY_CLOSE = 1;
}
