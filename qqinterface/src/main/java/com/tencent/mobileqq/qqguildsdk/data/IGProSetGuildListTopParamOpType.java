package com.tencent.mobileqq.qqguildsdk.data;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public  @interface IGProSetGuildListTopParamOpType {
    public static final int OPTYPE_CANCEL_TOP = 2;
    public static final int OPTYPE_TOP = 1;
}
