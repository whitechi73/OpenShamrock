package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public  @interface GGProUpgradeGroupOperateType {
    public static final int DELAY_UPGRADE = 2;
    public static final int NOW_UPGRADE = 1;
    public static final int UNKNOWN_TYPE = 0;
}
