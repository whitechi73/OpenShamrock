package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public  @interface GGProGuildMemberType {
    public static final int MEMBER = 2;
    public static final int VISITOR = 1;
}
