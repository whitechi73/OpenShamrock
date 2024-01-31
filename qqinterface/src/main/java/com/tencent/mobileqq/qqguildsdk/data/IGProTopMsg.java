package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;


public interface IGProTopMsg extends Serializable {
    long getTopMsgOperatorTinyId();

    long getTopMsgSeq();

    long getTopMsgTime();

    int getTopMsgType();
}
