package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProRecommendLiveChannel;
import com.tencent.qqnt.kernel.nativeinterface.GProRecommendMsg;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProRecommendLiveChannel implements IGProRecommendLiveChannel {
    public final GProRecommendLiveChannel mInfo;

    public GGProRecommendLiveChannel(GProRecommendLiveChannel gProRecommendLiveChannel) {
        this.mInfo = gProRecommendLiveChannel;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendLiveChannel
    public IGProRecommendCoverInfo getCover() {
        return new GGProRecommendCoverInfo(this.mInfo.getCover());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendLiveChannel
    public IGProLiveRoomInfo getLiveChannel() {
        return new GGProLiveRoomInfo(this.mInfo.getLiveChannel());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendLiveChannel
    public ArrayList<IGProRecommendMsg> getMsgList() {
        ArrayList<GProRecommendMsg> msgList = this.mInfo.getMsgList();
        ArrayList<IGProRecommendMsg> arrayList = new ArrayList<>();
        Iterator<GProRecommendMsg> it = msgList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProRecommendMsg(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendLiveChannel
    public String toString() {
        return this.mInfo.toString();
    }
}
