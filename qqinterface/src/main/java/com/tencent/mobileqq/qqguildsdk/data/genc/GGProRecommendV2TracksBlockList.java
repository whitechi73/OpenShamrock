package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProRecommendV2Channel;
import com.tencent.qqnt.kernel.nativeinterface.GProRecommendV2TracksBlockList;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProRecommendV2TracksBlockList implements IGProRecommendV2TracksBlockList {
    public final GProRecommendV2TracksBlockList mInfo;

    public GGProRecommendV2TracksBlockList(GProRecommendV2TracksBlockList gProRecommendV2TracksBlockList) {
        this.mInfo = gProRecommendV2TracksBlockList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendV2TracksBlockList
    public String getBlockName() {
        return this.mInfo.getBlockName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendV2TracksBlockList
    public ArrayList<IGProRecommendV2Channel> getChannelList() {
        ArrayList<GProRecommendV2Channel> channelList = this.mInfo.getChannelList();
        ArrayList<IGProRecommendV2Channel> arrayList = new ArrayList<>();
        Iterator<GProRecommendV2Channel> it = channelList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProRecommendV2Channel(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendV2TracksBlockList
    public String toString() {
        return this.mInfo.toString();
    }
}
