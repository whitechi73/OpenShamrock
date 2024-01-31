package com.tencent.mobileqq.qqguildsdk.data.genc;


import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProRecommendRobotTextChannel extends Serializable {
    ArrayList<String> getAvatars();

    IGProRecommendChannelInfo getChannelInfo();

    //ArrayList<ew> getMsgAbstracts();

    String toString();
}
