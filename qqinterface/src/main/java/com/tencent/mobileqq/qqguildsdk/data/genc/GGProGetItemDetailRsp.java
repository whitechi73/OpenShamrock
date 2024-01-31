package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProGetItemDetailRsp;
import com.tencent.qqnt.kernel.nativeinterface.GProRecommendItem;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProGetItemDetailRsp implements IGProGetItemDetailRsp {
    public final GProGetItemDetailRsp mInfo;

    public GGProGetItemDetailRsp(GProGetItemDetailRsp gProGetItemDetailRsp) {
        this.mInfo = gProGetItemDetailRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetItemDetailRsp
    public byte[] getCookies() {
        return this.mInfo.getCookies();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetItemDetailRsp
    public boolean getIsEnd() {
        return this.mInfo.getIsEnd();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetItemDetailRsp
    public ArrayList<IGProRecommendItem> getItems() {
        ArrayList<GProRecommendItem> items = this.mInfo.getItems();
        ArrayList<IGProRecommendItem> arrayList = new ArrayList<>();
        Iterator<GProRecommendItem> it = items.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProRecommendItem(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetItemDetailRsp
    public String getMsg() {
        return this.mInfo.getMsg();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetItemDetailRsp
    public int getNextTs() {
        return this.mInfo.getNextTs();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetItemDetailRsp
    public String getRequestId() {
        return this.mInfo.getRequestId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetItemDetailRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
