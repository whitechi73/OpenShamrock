package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public  @interface GGProSwitchType {
    public static final int AV_CHANNEL_PUBLIC_CHAT_SWITCH = 14;
    public static final int FEED_CHANNEL_PUBLISH_SWITCH = 12;
    public static final int FEED_CHANNEL_SHARE_SWITCH = 13;
    public static final int INVALID_SWITCH = 0;
    public static final int LIVE_CHANNEL_PUBLIC_CHAT_SWITCH = 7;
    public static final int LIVE_SWITCH = 1;
    public static final int SCREEN_SHARE_SWITCH = 3;
    public static final int TEXT_CHANNEL_CHAT_EMOJI_SWITCH = 11;
    public static final int TEXT_CHANNEL_CHAT_FILE_SWITCH = 10;
    public static final int TEXT_CHANNEL_CHAT_PIC_SWITCH = 8;
    public static final int TEXT_CHANNEL_CHAT_VIDEO_SWITCH = 9;
    public static final int VOICE_SWITCH = 2;
}
