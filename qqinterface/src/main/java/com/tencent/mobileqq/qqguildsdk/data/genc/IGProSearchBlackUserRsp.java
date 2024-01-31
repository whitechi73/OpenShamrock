package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProSearchBlackUserRsp extends Serializable {
    byte[] getBuf();

    long getGuildId();

    String getKeyword();

    ArrayList<IGProBlackUserInfo> getMemberList();

    long getNextPos();

    String getTraceId();

    String toString();
}
