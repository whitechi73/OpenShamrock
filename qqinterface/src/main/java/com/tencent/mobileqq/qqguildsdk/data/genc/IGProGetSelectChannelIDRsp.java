package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProGetSelectChannelIDRsp extends Serializable {
    ArrayList<Long> getGuildIds();

    ArrayList<IGProGuildInfoInLabel> getGuildInfos();

    String toString();
}
