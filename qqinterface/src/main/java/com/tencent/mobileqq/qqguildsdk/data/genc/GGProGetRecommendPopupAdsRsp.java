package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProGetRecommendPopupAdsRsp;
import com.tencent.qqnt.kernel.nativeinterface.GProRecommendPopupAdsInfo;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProGetRecommendPopupAdsRsp implements IGProGetRecommendPopupAdsRsp {
    public final GProGetRecommendPopupAdsRsp mInfo;

    public GGProGetRecommendPopupAdsRsp(GProGetRecommendPopupAdsRsp gProGetRecommendPopupAdsRsp) {
        this.mInfo = gProGetRecommendPopupAdsRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRecommendPopupAdsRsp
    public ArrayList<IGProRecommendPopupAdsInfo> getAdsInfoList() {
        ArrayList<GProRecommendPopupAdsInfo> adsInfoList = this.mInfo.getAdsInfoList();
        ArrayList<IGProRecommendPopupAdsInfo> arrayList = new ArrayList<>();
        Iterator<GProRecommendPopupAdsInfo> it = adsInfoList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProRecommendPopupAdsInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRecommendPopupAdsRsp
    public byte[] getCookies() {
        return this.mInfo.getCookies();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRecommendPopupAdsRsp
    public int getNextTs() {
        return this.mInfo.getNextTs();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRecommendPopupAdsRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
