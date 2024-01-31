package com.tencent.mobileqq.qqguildsdk.data;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Retention(RetentionPolicy.SOURCE)
public  @interface ISpeakLimitType {
    public static final int CHANNEL_READ_ONLY = 4;
    public static final int CHANNEL_READ_ONLY_JUMP_CHANNEL = 6;
    public static final int CHANNEL_READ_ONLY_LIVE_ANCHOR_MUTE = 5;
    public static final int DIRECT_MSG_THRESHOLD = 2;
    public static final int GUEST_INTERACT_LIMIT = 8;
    public static final int GUEST_PREVIEW_CHANNEL_LIMIT = 7;
    public static final int GUEST_REAL_AUTH_LIMIT = 9;
    public static final int GUILD_MUTE = 3;
    public static final int GUILD_MUTE_ALL = 10;
    public static final int GUILD_MUTE_SELF = 11;
    public static final int GUILD_ROLE_CATEGORY_ADMIN = 15;
    public static final int GUILD_ROLE_CHANNEL_ADMIN = 14;
    public static final int GUILD_ROLE_GUEST = 0;
    public static final int GUILD_ROLE_GUILD_ADMIN = 13;
    public static final int GUILD_ROLE_OWNER = 12;
    public static final int GUILD_SPEAK_THRESHOLD = 1;
}
