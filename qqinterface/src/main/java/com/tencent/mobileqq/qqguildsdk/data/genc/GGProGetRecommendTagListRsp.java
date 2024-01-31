package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProGetRecommendTagListRsp;
import com.tencent.qqnt.kernel.nativeinterface.GProRecommendItem;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProGetRecommendTagListRsp implements IGProGetRecommendTagListRsp {
    public final GProGetRecommendTagListRsp mInfo;

    public GGProGetRecommendTagListRsp(GProGetRecommendTagListRsp gProGetRecommendTagListRsp) {
        this.mInfo = gProGetRecommendTagListRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRecommendTagListRsp
    public byte[] getCookies() {
        return this.mInfo.getCookies();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRecommendTagListRsp
    public IGProRecommendExtInfo getExtInfo() {
        return new GGProRecommendExtInfo(this.mInfo.getExtInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRecommendTagListRsp
    public ArrayList<IGProRecommendItem> getRecommendList() {
        ArrayList<GProRecommendItem> recommendList = this.mInfo.getRecommendList();
        ArrayList<IGProRecommendItem> arrayList = new ArrayList<>();
        Iterator<GProRecommendItem> it = recommendList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProRecommendItem(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRecommendTagListRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
