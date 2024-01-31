package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProGetSubjectGuildsRsp;
import com.tencent.qqnt.kernel.nativeinterface.GProRecommendItem;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProGetSubjectGuildsRsp implements IGProGetSubjectGuildsRsp {
    public final GProGetSubjectGuildsRsp mInfo;

    public GGProGetSubjectGuildsRsp(GProGetSubjectGuildsRsp gProGetSubjectGuildsRsp) {
        this.mInfo = gProGetSubjectGuildsRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetSubjectGuildsRsp
    public int getAllCnt() {
        return this.mInfo.getAllCnt();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetSubjectGuildsRsp
    public byte[] getCookies() {
        return this.mInfo.getCookies();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetSubjectGuildsRsp
    public ArrayList<IGProRecommendItem> getItems() {
        ArrayList<GProRecommendItem> items = this.mInfo.getItems();
        ArrayList<IGProRecommendItem> arrayList = new ArrayList<>();
        Iterator<GProRecommendItem> it = items.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProRecommendItem(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetSubjectGuildsRsp
    public String getTraceId() {
        return this.mInfo.getTraceId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetSubjectGuildsRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
