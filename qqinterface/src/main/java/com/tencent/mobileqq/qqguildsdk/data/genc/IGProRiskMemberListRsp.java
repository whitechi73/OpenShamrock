package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProRiskMemberListRsp extends Serializable {
    byte[] getBuf();

    String getCookie();

    ArrayList<IGProRiskMemberGroupInfo> getGroupList();

    boolean getIsEnd();

    String getSubTitle();

    String getTitle();

    long getTotalNum();

    String getTraceId();

    String toString();
}
