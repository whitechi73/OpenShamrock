package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;


public interface IGProChannelUserNum extends Serializable {
    long getDataVersion();

    int getPlayersNum();

    int getRobotNum();

    int getShowThreshold();

    int getSpeakOrderNum();

    int getUserNum();

    int getViewersNum();

    String toString();
}
