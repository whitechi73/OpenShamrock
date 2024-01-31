package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProLiveRoomInfo;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProLiveResultItem extends Serializable {
    IGProLiveRoomInfo getLiveChannel();

    //ArrayList<ew> getMsgAbstracts();
}
