package com.tencent.mobileqq.qqguildsdk.data;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
public  @interface IWorldChannelState$IAudioRoomState {
    public static final int DEFAULT = 0;
    public static final int IN_SPEECHING = 4;
    public static final int LIVING = 1;
    public static final int NO_LIVING = 2;
    public static final int NO_SPEECHING = 3;
    public static final int PLAYING_GAME = 7;
    public static final int SCREEN_SHARING = 6;
    public static final int WORLD_PLAYING = 8;
}
