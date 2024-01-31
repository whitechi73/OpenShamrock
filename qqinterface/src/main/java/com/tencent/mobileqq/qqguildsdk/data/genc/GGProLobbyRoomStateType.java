package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public  @interface GGProLobbyRoomStateType {
    public static final int LOBBY_STATUS_END = 3;
    public static final int LOBBY_STATUS_GAMEING = 2;
    public static final int LOBBY_STATUS_INVALID = 0;
    public static final int LOBBY_STATUS_TEAMING = 1;
}
