package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public  @interface GGProSearchExtendReqType {
    public static final int DEFAULT = 0;
    public static final int NEXT_PAGE_RECOMMEND_GUILD = 1;
}
