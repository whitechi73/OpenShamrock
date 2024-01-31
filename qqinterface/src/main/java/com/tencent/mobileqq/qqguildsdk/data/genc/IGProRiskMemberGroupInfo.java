package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProRiskMemberGroupInfo extends Serializable {
    long getGroupId();

    String getGroupName();

    ArrayList<IGProBlackUserInfo> getRptMemberList();

    int getTotalNum();

    String toString();
}
