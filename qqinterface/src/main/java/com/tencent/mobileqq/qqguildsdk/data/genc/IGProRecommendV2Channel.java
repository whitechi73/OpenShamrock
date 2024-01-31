package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProRecommendV2Channel extends Serializable {
    long getBrowseTimeStamp();

    String getCoverUrl();

    String getGuildIcon();

    long getGuildId();

    String getGuildName();

    String getGuildProfile();

    String getJoinGuildSig();

    int getJoinedGuild();

    ArrayList<Object> getLabelList();

    int getMemberRole();

    long getOwnerUin();

    ArrayList<IGProRecommendGuildState> getStateList();

    ArrayList<String> getTagList();

    long getUniqueId();

    String toString();
}
