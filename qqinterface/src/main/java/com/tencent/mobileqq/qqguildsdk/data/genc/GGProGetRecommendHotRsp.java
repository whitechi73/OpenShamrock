package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProGetRecommendHotRsp;
import com.tencent.qqnt.kernel.nativeinterface.GProRecommendItem;

import java.util.ArrayList;
import java.util.Iterator;


public class GGProGetRecommendHotRsp implements IGProGetRecommendHotRsp {
    public final GProGetRecommendHotRsp mInfo;

    public GGProGetRecommendHotRsp(GProGetRecommendHotRsp gProGetRecommendHotRsp) {
        this.mInfo = gProGetRecommendHotRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRecommendHotRsp
    public byte[] getCookies() {
        return this.mInfo.getCookies();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRecommendHotRsp
    public IGProRecommendExtInfo getExtInfo() {
        return new GGProRecommendExtInfo(this.mInfo.getExtInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRecommendHotRsp
    public ArrayList<IGProRecommendItem> getRecommendList() {
        ArrayList<GProRecommendItem> recommendList = this.mInfo.getRecommendList();
        ArrayList<IGProRecommendItem> arrayList = new ArrayList<>();
        Iterator<GProRecommendItem> it = recommendList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProRecommendItem(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRecommendHotRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
