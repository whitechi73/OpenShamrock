package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

public  interface IGProGetAtMeMsgRsp extends Serializable {
    IGProRecommendExtInfo getExtInfo();

    ArrayList<IGProRecommendChannelInfo> getMsgList();

    int getNextTs();

    String toString();
}
