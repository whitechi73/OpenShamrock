package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProGetCurrPlaySongRsp extends Serializable {
    IGProPlayInfo getPlayInfo();

    IGProListenTogetherRspHead getRspHead();

    String toString();
}
