package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProRetentionGuildListRsp extends Serializable {
    byte[] getCookies();

    boolean getIsEnd();

    int getNextTs();

    ArrayList<IGProRetentionChannelInfo> getRecommendChannels();

    String toString();
}
