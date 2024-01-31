package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProRecommendRobotDrawCard extends Serializable {
    String getBotMsgId();

    String getImgUrl();

    IGProRecommendRobotInfo getRobotInfo();

    String getTitle();

    String getUserMsgId();

    String toString();
}
