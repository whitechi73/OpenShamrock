package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProStickyTextChannel extends Serializable {
    String getActiveMemberCount();

    ArrayList<IGProUserInfo> getActiveMemberList();

    //ArrayList<ew> getMsgAbstracts();

    ArrayList<IGProMsgSummary> getMsgList();
}
