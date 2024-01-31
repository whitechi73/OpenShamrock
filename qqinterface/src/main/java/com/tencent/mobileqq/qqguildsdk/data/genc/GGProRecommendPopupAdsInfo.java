package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProBlockBaseInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProRecommendPopupAdsInfo;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProRecommendPopupAdsInfo implements IGProRecommendPopupAdsInfo {
    public final GProRecommendPopupAdsInfo mInfo;

    public GGProRecommendPopupAdsInfo(GProRecommendPopupAdsInfo gProRecommendPopupAdsInfo) {
        this.mInfo = gProRecommendPopupAdsInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendPopupAdsInfo
    public ArrayList<IGProBlockBaseInfo> getList() {
        ArrayList<GProBlockBaseInfo> list = this.mInfo.getList();
        ArrayList<IGProBlockBaseInfo> arrayList = new ArrayList<>();
        Iterator<GProBlockBaseInfo> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProBlockBaseInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendPopupAdsInfo
    public int getTabType() {
        return this.mInfo.getTabType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendPopupAdsInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
