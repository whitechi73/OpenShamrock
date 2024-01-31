package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernel.nativeinterface.GProTopMsg;


public class GProTopMsgInfo implements IGProTopMsg {
    public GProTopMsg mInfo;

    public GProTopMsgInfo(GProTopMsg gProTopMsg) {
        this.mInfo = gProTopMsg;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProTopMsg
    public long getTopMsgOperatorTinyId() {
        return this.mInfo.getTopMsgOperatorTinyId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProTopMsg
    public long getTopMsgSeq() {
        return this.mInfo.getTopMsgSeq();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProTopMsg
    public long getTopMsgTime() {
        return this.mInfo.getTopMsgTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProTopMsg
    public int getTopMsgType() {
        //return this.mInfo.getTopMsgType();
        return 0;
    }
}
