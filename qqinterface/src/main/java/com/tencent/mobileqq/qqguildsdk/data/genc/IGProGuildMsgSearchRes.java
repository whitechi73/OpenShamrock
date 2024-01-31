package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProGuildMsgSearchRes extends Serializable {
    String getAvatar();

    long getChannelId();

    long getGuildId();

    long getMsgSeq();

    String getMsgTxt();

    String getNickName();

    String getPics();

    long getTimeStamp();

    long getTinyId();

    int getUserType();

    String getVideos();

    String toString();
}
