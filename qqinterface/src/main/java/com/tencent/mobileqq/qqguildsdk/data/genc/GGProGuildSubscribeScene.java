package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public  @interface GGProGuildSubscribeScene {
    public static final int DEFAULT_SCENE = 0;
    public static final int FAST_SUBSCRIBE_SCENE = 1;
}
