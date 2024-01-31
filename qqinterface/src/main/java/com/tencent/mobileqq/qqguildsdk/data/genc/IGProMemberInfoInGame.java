package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProMemberInfoInGame extends Serializable {
    String getBackgroundPic();

    int getGameIdentity();

    int getGameStatus();

    long getGameStatusUpdateTimestampMs();

    ArrayList<String> getGoodHeroIconList();

    int getGradeLevel();

    String getGradeLevelIcon();

    String getHeroName();

    String getHeroPic();

    String getHonorDesc();

    String getHonorIcon();

    String getIdentityDesc();

    long getJoinTimestampMs();

    String getNickName();

    String getRecord();

    long getRoomId();

    String getSchema();

    long getTinyId();

    String toString();
}
