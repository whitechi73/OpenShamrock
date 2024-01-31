package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public  @interface GGProLobbyAuthStatusType {
    public static final int AUTHORIZED = 1;
    public static final int UNAUTHORIZED = 2;
    public static final int UNDEFINED = 0;
}
