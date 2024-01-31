package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.mobileqq.qqguildsdk.data.IGProStickyFeedChannel;
import com.tencent.mobileqq.qqguildsdk.data.IGProStickyTextChannel;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProRecommendItem extends Serializable {
    IGProStickyFeedChannel getActiveFeedChannel();

    IGProStickyTextChannel getActiveTextChannel();

    IGProActiveUser getActiveUser();

    byte[] getAdFeedModel();

    IGProAdInfo getAdInfo();

    ArrayList<IGProRecommendCategory> getCategories();

    IGProRecommendChannelInfo getChannelInfo();

    IGProRecommendExtra getExtra();

    IGProRecommendMyFeed getFeed();

    IGProRecommendItemForumChannel getForumChannel();

    IGProRecommendH5GameChannel getH5gameChannel();

    IGProItemHeadInfo getItemHeadInfo();

    String getItemId();

    long getItemIdUint64();

    int getItemType();

    IGProPageHeadInfo getPageHeadInfo();

    IGProQuickJoinBlock getQuickJoinBlock();

    IGProRecommendLiveChannel getRecommendLiveChannel();

    ArrayList<String> getRecommendReasons();

    IGProRecommendRobotDrawCard getRobotDrawCard();

    IGProRecommendRobotGameCard getRobotGameCard();

    IGProSearchItem getSearchItem();

    int getTemplateType();

    IGProRecommendTextChannel getTextChannel();

    IGProRecommendVoiceChannel getVoiceChannel();

    IGProVoiceTemplateChannel getVoiceTemplate();

    String toString();
}
