package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProRecommendRobotInfo extends Serializable {
    String getAvatar();

    String getDesc();

    ArrayList<String> getIntroduceList();

    String getName();

    long getRobotUin();

    String toString();
}
