package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProGuildFeedSearchRes extends Serializable {
    long getChannelId();

    long getCommentCount();

    String getContent();

    long getCreateTime();

    long getFavorCount();

    String getFeedId();

    long getGuildId();

    ArrayList<IGProFeedImageEntity> getImages();

    String getNickName();

    long getTinyId();

    String getTitle();

    ArrayList<IGProFeedImageEntity> getVideos();

    String toString();
}
