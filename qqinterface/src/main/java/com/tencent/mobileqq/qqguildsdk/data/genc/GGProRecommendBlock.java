package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public  @interface GGProRecommendBlock {
    public static final int BLOCK_ACTIVE_USER = 8;
    public static final int BLOCK_FORUM_HEAD = 10;
    public static final int BLOCK_HOT_FORUM = 3;
    public static final int BLOCK_RECENT_VISIT = 6;
    public static final int BLOCK_REC_GUILD = 1;
    public static final int BLOCK_REC_GUILD_SLIDE = 9;
    public static final int BLOCK_REC_ROOM = 2;
    public static final int BLOCK_REC_SUBSCRIBE = 7;
    public static final int BLOCK_SUBJECT_CARD = 5;
    public static final int BLOCK_SUBJECT_TRUMP = 4;
    public static final int BLOCK_UNKOWN = 0;
}
