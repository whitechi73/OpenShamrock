package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public  @interface GGProTemplateTypeEnum {
    public static final int TEMPLATE_TYPE_UNKOWN = 0;
    public static final int TEMPLATE_TYPE_VOICE = 1;
}
