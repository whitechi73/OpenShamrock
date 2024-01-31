package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProGetAtMeMsgRsp;
import com.tencent.qqnt.kernel.nativeinterface.GProRecommendChannelInfo;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProGetAtMeMsgRsp implements IGProGetAtMeMsgRsp {
    public final GProGetAtMeMsgRsp mInfo;

    public GGProGetAtMeMsgRsp(GProGetAtMeMsgRsp gProGetAtMeMsgRsp) {
        this.mInfo = gProGetAtMeMsgRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetAtMeMsgRsp
    public IGProRecommendExtInfo getExtInfo() {
        return new GGProRecommendExtInfo(this.mInfo.getExtInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetAtMeMsgRsp
    public ArrayList<IGProRecommendChannelInfo> getMsgList() {
        ArrayList<GProRecommendChannelInfo> msgList = this.mInfo.getMsgList();
        ArrayList<IGProRecommendChannelInfo> arrayList = new ArrayList<>();
        Iterator<GProRecommendChannelInfo> it = msgList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProRecommendChannelInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetAtMeMsgRsp
    public int getNextTs() {
        return this.mInfo.getNextTs();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetAtMeMsgRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
