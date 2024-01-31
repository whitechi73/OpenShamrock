package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public  @interface GGProLobbyAppFullScreenMode {
    public static final int HORIZONTAL = 2;
    public static final int NO = 0;
    public static final int VERTICAL = 1;
    public static final int VERTICALANDHORIZONTAL = 3;
}
