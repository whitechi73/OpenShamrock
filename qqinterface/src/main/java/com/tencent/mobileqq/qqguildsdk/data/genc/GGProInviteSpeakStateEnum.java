package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public  @interface GGProInviteSpeakStateEnum {
    public static final int STATE_DEFAULT = 0;
    public static final int STATE_DISABLE = 2;
    public static final int STATE_ENABLE = 1;
}
