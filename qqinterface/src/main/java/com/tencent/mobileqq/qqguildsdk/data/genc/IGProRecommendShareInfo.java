package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProRecommendShareInfo extends Serializable {
    IGProBusinessData getBizData();

    long getChannelId();

    String getGuildCoverUrl();

    String getGuildIcon();

    long getGuildId();

    String getGuildName();

    String getJoinGuildSig();

    int getJoinedGuild();

    int getMemberRole();

    String getShareLink();

    IGProRecommendShareLive getShareLive();

    int getShareTag();

    int getShareType();

    String toString();
}
