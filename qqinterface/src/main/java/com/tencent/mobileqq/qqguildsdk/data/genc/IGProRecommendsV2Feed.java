package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProRecommendsV2Feed extends Serializable {
    ArrayList<String> getAttributeTags();

    String getBannerUrl();

    String getButtonColor();

    String getButtonDesc();

    String getButtonDescColor();

    String getCardBottomColor();

    long getCardId();

    long getCardTank();

    String getCardUrl();

    long getChannelId();

    String getChannelInfoColor();

    String getContentId();

    long getCreateTime();

    int getFavorCnt();

    int getFeedCardType();

    String getFeedCoverUrl();

    String getFeedId();

    String getFeedSubTitle();

    String getFeedTitle();

    String getFeedVideoCoverUrl();

    long getGuildId();

    int getImageRatioType();

    String getInviteCode();

    int getIsMore();

    long getPosterTinyId();

    String getTitleColor();

    String toString();
}
