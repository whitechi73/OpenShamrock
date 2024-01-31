package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public  final class GProTopMsg implements Serializable {
    long serialVersionUID = 1;
    long topMsgOperatorTinyId;
    long topMsgSeq;
    long topMsgTime;

    public GProTopMsg() {
    }

    public long getTopMsgOperatorTinyId() {
        return this.topMsgOperatorTinyId;
    }

    public long getTopMsgSeq() {
        return this.topMsgSeq;
    }

    public long getTopMsgTime() {
        return this.topMsgTime;
    }

    public String toString() {
        return "GProTopMsg{topMsgSeq=" + this.topMsgSeq + ",topMsgTime=" + this.topMsgTime + ",topMsgOperatorTinyId=" + this.topMsgOperatorTinyId + ",}";
    }

    public GProTopMsg(long j2, long j3, long j4) {
        this.topMsgSeq = j2;
        this.topMsgTime = j3;
        this.topMsgOperatorTinyId = j4;
    }
}
