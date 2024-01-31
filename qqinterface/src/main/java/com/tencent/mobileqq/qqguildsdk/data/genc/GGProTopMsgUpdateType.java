package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public  @interface GGProTopMsgUpdateType {
    public static final int UPDATE_ALL = 1;
    public static final int UPDATE_INCREMENT = 0;
}
