package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProGetInvitationGuildRsp extends Serializable {
    byte[] getCookies();

    IGProRecommendItem getItem();

    int getNextTs();

    String getTraceId();

    String toString();
}
