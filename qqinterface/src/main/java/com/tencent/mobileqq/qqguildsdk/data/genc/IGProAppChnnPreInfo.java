package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;


public interface IGProAppChnnPreInfo extends Serializable {
    long getAppid();

    long getChannelId();

    ArrayList<IGProChannelPresenceInfo> getChnnPreList();

    String getChnnPreSeq();

    long getGuildId();

    IGProJoinCondition getJoinCondition();

    int getJumpType();

    String getJumpUrl();

    int getNextTimeStamp();

    int getResult();

    String getText();

    String toString();
}
