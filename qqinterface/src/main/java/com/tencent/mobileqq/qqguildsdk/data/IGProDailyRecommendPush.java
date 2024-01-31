package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;


public interface IGProDailyRecommendPush extends Serializable {
    String getAvatar();

    String getJumpLink();

    String getSubTitle();

    String getTitle();
}
