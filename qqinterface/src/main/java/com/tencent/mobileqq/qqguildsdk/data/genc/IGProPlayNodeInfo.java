package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProPlayNodeInfo extends Serializable {
    int getAccessFlag();

    long getAddTime();

    long getAddTinyId();

    String getAddUserAvatarMeta();

    String getAddUserName();

    ArrayList<String> getBackgroundColorList();

    long getOrderNum();

    String getPlayNodeId();

    int getPlaySourceDuration();

    String getPlaySourceId();

    String getPlaySourceName();

    String getPlaySourcePic();

    String getPlaySourceShowName();

    String getSingerList();

    String getThirdSourceIcon();

    String getThirdSourceId();

    String toString();
}
