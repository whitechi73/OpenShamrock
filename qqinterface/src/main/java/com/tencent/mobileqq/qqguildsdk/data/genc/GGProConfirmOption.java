package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProConfirmNode;
import com.tencent.qqnt.kernel.nativeinterface.GProConfirmOption;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProConfirmOption implements IGProConfirmOption {
    public final GProConfirmOption mInfo;

    public GGProConfirmOption(GProConfirmOption gProConfirmOption) {
        this.mInfo = gProConfirmOption;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProConfirmOption
    public String getConfirmMsg() {
        return this.mInfo.getConfirmMsg();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProConfirmOption
    public ArrayList<Object> getConfirmNodes() {
        ArrayList<GProConfirmNode> confirmNodes = this.mInfo.getConfirmNodes();
        ArrayList<Object> arrayList = new ArrayList<>();
        Iterator<GProConfirmNode> it = confirmNodes.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProConfirmNode(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProConfirmOption
    public String toString() {
        return this.mInfo.toString();
    }
}
