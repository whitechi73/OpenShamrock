package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProRecommendItemForumChannel extends Serializable {
    int getEndColor();

    int getHotFeedNum();

    String getHotIcon();

    int getHotValue();

    String getHotValueTitle();

    int getIndex();

    String getInviteCode();

    int getStartColor();

    int getType();

    String toString();
}
