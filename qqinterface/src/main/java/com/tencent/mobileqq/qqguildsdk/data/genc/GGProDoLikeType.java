package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public  @interface GGProDoLikeType {
    public static final int LIKE_COMMENT_TYPE = 3;
    public static final int LIKE_REPLY_TYPE = 5;
    public static final int LIKE_TYPE = 1;
    public static final int REWARD_TYPE = 21;
    public static final int SWITCH_LIKE_TYPE = 2;
    public static final int UNLIKE_COMMENT_TYPE = 4;
    public static final int UNLIKE_REPLY_TYPE = 6;
    public static final int UNLIKE_TYPE = 0;
    public static final int UNREWARD_TYPE = 22;
}
