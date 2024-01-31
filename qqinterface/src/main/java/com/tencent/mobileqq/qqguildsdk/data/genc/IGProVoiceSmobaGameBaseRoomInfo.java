package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProVoiceSmobaGameBaseRoomInfo extends Serializable {
    long getCaptainTinyId();

    long getChannelId();

    long getGuildId();

    long getRoomId();

    int getRoomType();

    String toString();
}
