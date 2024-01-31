package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProGlobalPrivacySwitchGroup extends Serializable {
    int getAddFriendSwitch();

    int getAllSwitch();

    int getJoinedGuildShowSwitch();

    int getPublishedFeedShowSwitch();

    int getQqProfileShowSwitch();

    int getRoomStateShowSwitch();

    String toString();
}
