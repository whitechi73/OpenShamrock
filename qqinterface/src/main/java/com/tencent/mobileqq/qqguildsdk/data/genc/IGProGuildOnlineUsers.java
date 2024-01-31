package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProGuildOnlineUsers extends Serializable {
    long getChannelId();

    int getChannelType();

    String getTotalOnline();

    ArrayList<IGProUserInfo> getUsers();

    String toString();
}
