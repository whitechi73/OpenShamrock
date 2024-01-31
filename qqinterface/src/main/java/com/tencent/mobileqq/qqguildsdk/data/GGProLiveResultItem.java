package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.GGProLiveRoomInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProLiveRoomInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProLiveResultItem;
import com.tencent.qqnt.kernel.nativeinterface.MsgAbstract;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProLiveResultItem implements IGProLiveResultItem {
    public final GProLiveResultItem mInfo;

    public GGProLiveResultItem(GProLiveResultItem gProLiveResultItem) {
        this.mInfo = gProLiveResultItem;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProLiveResultItem
    public IGProLiveRoomInfo getLiveChannel() {
        return new GGProLiveRoomInfo(this.mInfo.getLiveChannel());
    }

    //@Override // com.tencent.mobileqq.qqguildsdk.data.IGProLiveResultItem
    //public ArrayList<ew> getMsgAbstracts() {
    //    ArrayList<MsgAbstract> msgAbstracts = this.mInfo.getMsgAbstracts();
    //    ArrayList<ew> arrayList = new ArrayList<>();
    //    Iterator<MsgAbstract> it = msgAbstracts.iterator();
    //    while (it.hasNext()) {
    //        arrayList.add(new t(it.next()));
    //    }
    //    return arrayList;
    //}
}
