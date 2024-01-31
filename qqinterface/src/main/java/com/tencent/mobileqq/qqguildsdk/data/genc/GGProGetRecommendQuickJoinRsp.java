package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProGetRecommendQuickJoinRsp;
import com.tencent.qqnt.kernel.nativeinterface.GProRecommendQuickJoinItem;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProGetRecommendQuickJoinRsp implements IGProGetRecommendQuickJoinRsp {
    public final GProGetRecommendQuickJoinRsp mInfo;

    public GGProGetRecommendQuickJoinRsp(GProGetRecommendQuickJoinRsp gProGetRecommendQuickJoinRsp) {
        this.mInfo = gProGetRecommendQuickJoinRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRecommendQuickJoinRsp
    public ArrayList<IGProRecommendQuickJoinItem> getRecommendQuickJoinItems() {
        ArrayList<GProRecommendQuickJoinItem> recommendQuickJoinItems = this.mInfo.getRecommendQuickJoinItems();
        ArrayList<IGProRecommendQuickJoinItem> arrayList = new ArrayList<>();
        Iterator<GProRecommendQuickJoinItem> it = recommendQuickJoinItems.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProRecommendQuickJoinItem(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRecommendQuickJoinRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
