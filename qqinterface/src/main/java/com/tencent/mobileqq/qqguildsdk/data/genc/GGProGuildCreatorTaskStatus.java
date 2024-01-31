package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public  @interface GGProGuildCreatorTaskStatus {
    public static final int DEFAULT = 0;
    public static final int DONE = 1;
    public static final int UNDONE = 2;
}
