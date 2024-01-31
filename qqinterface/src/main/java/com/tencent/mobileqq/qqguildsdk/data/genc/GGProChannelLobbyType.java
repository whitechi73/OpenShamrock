package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public  @interface GGProChannelLobbyType {
    public static final int PRIVATE = 1;
    public static final int PUBLIC = 0;
}
