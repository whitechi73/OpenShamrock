package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public  @interface GGProRecommendBussiLabelType {
    public static final int BUSSI_LABEL_AUTH = 4;
    public static final int BUSSI_LABEL_HONOR = 3;
    public static final int BUSSI_LABEL_NUM = 1;
    public static final int BUSSI_LABEL_REASON = 2;
    public static final int BUSSI_LABEL_UNKOWN = 0;
}
