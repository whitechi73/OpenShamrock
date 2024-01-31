package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProGetRiskMemberRedPointRsp extends Serializable {
    long getDuration();

    long getSeqNo();

    String getTips();

    String toString();
}
