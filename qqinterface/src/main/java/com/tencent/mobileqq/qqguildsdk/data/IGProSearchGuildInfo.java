package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProMedalInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendLabel;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProSearchRankInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProSuggestedSearch;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public  interface IGProSearchGuildInfo extends Serializable {
    String getCoverUrl();

    //List<dl> getGuildChannelStates();

    String getGuildId();

     long getGuildIdLong();

    String getGuildNumber();

     ArrayList<Object> getGuildStates();

    String getHeadUrl();

     ArrayList<String> getHighlightWords();

    String getJoinGuildSig();

    int getJoinedGuild();

    ArrayList<IGProRecommendLabel> getLabelList();

    ArrayList<IGProMedalInfo> getMedalInfoList();

    int getMedalLevel();

    String getName();

     IGProRecommendLabel getPeopleLabel();

    String getProfile();

     ArrayList<IGProSearchRankInfo> getRankList();

    IRecallInfo getRecallInfo();

     IGProRecommendLabel getRecommendReason();

     int getShowType();

     IGProSuggestedSearch getSuggestedSearchInfo();

    ArrayList<String> getTags();
}
