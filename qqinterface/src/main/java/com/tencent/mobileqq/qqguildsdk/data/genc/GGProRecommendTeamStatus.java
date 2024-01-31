package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public  @interface GGProRecommendTeamStatus {
    public static final int TEAM_STATUS_GAME_OVER = 10;
    public static final int TEAM_STATUS_IDLE = 1;
    public static final int TEAM_STATUS_INIT = 0;
    public static final int TEAM_STATUS_IN_GAME = 3;
    public static final int TEAM_STATUS_STARTING = 2;
}
