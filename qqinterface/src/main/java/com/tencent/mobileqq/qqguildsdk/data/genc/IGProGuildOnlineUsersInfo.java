package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProGuildOnlineUsersInfo extends Serializable {
    int getGroupType();

    ArrayList<IGProGuildOnlineUsers> getGroupUsers();

    long getGuildId();

    long getNextReadInterval();

    String toString();
}
