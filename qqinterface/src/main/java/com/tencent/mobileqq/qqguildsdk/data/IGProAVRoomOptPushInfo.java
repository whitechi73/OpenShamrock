package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;


public interface IGProAVRoomOptPushInfo extends Serializable {
    String getChannelId();

    String getDelRoomId();

    String getGuildId();

    int getOptType();

    IGProAVRoomAddUpInfo getRoomAddUpInfo();

    IGProAVShowMsgInfo getShowInfo();

    String getSwitchRoomId();
}
