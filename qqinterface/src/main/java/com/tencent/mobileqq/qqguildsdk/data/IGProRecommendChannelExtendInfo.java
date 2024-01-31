package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;

public  interface IGProRecommendChannelExtendInfo extends Serializable {
    int getAreaType();

    long getChannelId();

    String getChannelLink();

    int getChannelLinkType();

    String getGuildFace();

    int getHideVisitorStyle();
}
