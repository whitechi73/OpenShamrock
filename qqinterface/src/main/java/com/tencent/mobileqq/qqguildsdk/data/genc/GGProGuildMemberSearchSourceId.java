package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public  @interface GGProGuildMemberSearchSourceId {
    public static final int ADD_CATEGORY_ADMIN_MEMBER = 7;
    public static final int ADD_CHANNEL_ACTIVITY_SETTING_MEMBER = 16;
    public static final int ADD_CHANNEL_ADMIN_MEMBER = 6;
    public static final int ADD_CHANNEL_LIVE_SETTING_MEMBER = 14;
    public static final int ADD_CHANNEL_SPEAK_SETTING_MEMBER = 12;
    public static final int ADD_CHANNEL_VISIBLE_SETTING_MEMBER = 10;
    public static final int ADD_GUILD_ROLE_MEMBER = 5;
    public static final int ADD_GUILD_SPEAK_RULE_UNRESTRICTED_MEMBER = 20;
    public static final int ALL_MEMBER = 1;
    public static final int AV_CHANNEL_ONLINE_MEMBER = 17;
    public static final int CATEGORY_ADMIN_MEMBER = 4;
    public static final int CHANNEL_ACTIVITY_SETTING_MEMBER = 15;
    public static final int CHANNEL_ADMIN_MEMBER = 3;
    public static final int CHANNEL_AT_MEMBER = 18;
    public static final int CHANNEL_LIVE_SETTING_MEMBER = 13;
    public static final int CHANNEL_SPEAK_SETTING_MEMBER = 11;
    public static final int CHANNEL_VISIBLE_MEMBER = 8;
    public static final int CHANNEL_VISIBLE_SETTING_MEMBER = 9;
    public static final int DEFAULT = 0;
    public static final int GUILD_ROLE_MEMBER = 2;
    public static final int GUILD_SPEAK_RULE_UNRESTRICTED_MEMBER = 19;
}
