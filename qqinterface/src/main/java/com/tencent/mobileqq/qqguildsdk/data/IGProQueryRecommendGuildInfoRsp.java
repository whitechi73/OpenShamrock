package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;

public  interface IGProQueryRecommendGuildInfoRsp extends Serializable {
    byte[] getCookie();

    IGProGuildData getGuildData();

    long getNewDefaultChannelId();

    long getReqInterval();

    IGProRecommendGuildPersonalSetting getSetting();
}
