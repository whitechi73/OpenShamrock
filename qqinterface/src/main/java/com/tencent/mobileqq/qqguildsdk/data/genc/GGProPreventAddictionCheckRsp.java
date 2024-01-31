package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProPAInstructionInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProPreventAddictionCheckRsp;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProPreventAddictionCheckRsp implements IGProPreventAddictionCheckRsp {
    public final GProPreventAddictionCheckRsp mInfo;

    public GGProPreventAddictionCheckRsp(GProPreventAddictionCheckRsp gProPreventAddictionCheckRsp) {
        this.mInfo = gProPreventAddictionCheckRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPreventAddictionCheckRsp
    public String getContext() {
        return this.mInfo.getContext();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPreventAddictionCheckRsp
    public String getInstrTraceId() {
        return this.mInfo.getInstrTraceId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPreventAddictionCheckRsp
    public ArrayList<IGProPAInstructionInfo> getInstructions() {
        ArrayList<GProPAInstructionInfo> instructions = this.mInfo.getInstructions();
        ArrayList<IGProPAInstructionInfo> arrayList = new ArrayList<>();
        Iterator<GProPAInstructionInfo> it = instructions.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProPAInstructionInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPreventAddictionCheckRsp
    public String getMsg() {
        return this.mInfo.getMsg();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPreventAddictionCheckRsp
    public int getRet() {
        return this.mInfo.getRet();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPreventAddictionCheckRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
