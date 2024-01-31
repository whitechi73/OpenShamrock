package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public  @interface GGProGuildRoleDisplayType {
    public static final int CUSTOM_MANAGE_TAG = 1;
    public static final int DEFAULT = 0;
}
