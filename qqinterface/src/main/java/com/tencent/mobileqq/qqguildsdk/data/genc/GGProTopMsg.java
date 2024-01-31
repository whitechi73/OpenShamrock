package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProTopMsg;

import java.io.Serializable;

public  class GGProTopMsg implements Serializable {
    public final GProTopMsg mInfo;

    public GGProTopMsg(GProTopMsg gProTopMsg) {
        this.mInfo = gProTopMsg;
    }

    public long getTopMsgOperatorTinyId() {
        return this.mInfo.getTopMsgOperatorTinyId();
    }

    public long getTopMsgSeq() {
        return this.mInfo.getTopMsgSeq();
    }

    public long getTopMsgTime() {
        return this.mInfo.getTopMsgTime();
    }

    public int getTopMsgType() {
        return 0;
       // return this.mInfo.getTopMsgType();
    }

    public String toString() {
        return this.mInfo.toString();
    }
}
