package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

public  interface IGProRecommendSeqInfo extends Serializable {
    byte[] getMaxBytesReadMsgMeta();

    long getMaxCntSeq();

    long getMaxMsgSeq();

    String toString();
}
