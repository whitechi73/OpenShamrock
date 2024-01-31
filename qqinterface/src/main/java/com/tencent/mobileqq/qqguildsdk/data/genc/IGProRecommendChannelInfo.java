package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProRecommendChannelInfo extends Serializable {
    long getChannelId();

    String getChannelName();

    int getChannelType();

    String getCoverUrl();

    String getGuildIcon();

    long getGuildId();

    String getGuildName();

    String getGuildNumber();

    String getGuildProfile();

    int getIsWhole();

    String getItemId();

    String getJoinGuildSig();

    int getJoinedGuild();

    ArrayList<IGProMedalInfo> getMedalInfoList();

    int getMedalLevel();

    int getMemberRole();

    IGProRecommendSeqInfo getSeqInfo();

    String getShareLink();

    int getShareTag();

    ArrayList<IGProRecommendGuildState> getStateList();

    ArrayList<IGProRecommendLabel> getTagList();

    String getTitleName();

    long getUnreadAtMeCount();

    String toString();
}
