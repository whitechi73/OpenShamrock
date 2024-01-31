package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAVDevOptInfo;

import java.io.Serializable;

public  interface IGProAVRoomAddUpInfo extends Serializable {
    IGProAVDevOptInfo getAVDevOpt();

    int getMicVolume();

    String getRoomId();
}
