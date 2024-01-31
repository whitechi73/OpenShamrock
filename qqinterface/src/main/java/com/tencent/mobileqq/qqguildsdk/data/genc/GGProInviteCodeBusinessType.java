package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public  @interface GGProInviteCodeBusinessType {
    public static final int TYPE_DEFAULT = 0;
    public static final int TYPE_FEED = 2;
    public static final int TYPE_FEED_CHANNEL = 10;
    public static final int TYPE_FEED_SQUARE = 15;
    public static final int TYPE_GAME = 13;
    public static final int TYPE_GAME_BOARD = 14;
    public static final int TYPE_GUILD = 9;
    public static final int TYPE_GUILD_QRCODE = 5;
    public static final int TYPE_LIVE = 3;
    public static final int TYPE_MA_CHANNEL = 6;
    public static final int TYPE_META_CHANNEL = 12;
    public static final int TYPE_SCHEDULE = 1;
    public static final int TYPE_SCHEDULE_LIST = 8;
    public static final int TYPE_VOICE = 4;
    public static final int TYPE_WORD = 7;
}
