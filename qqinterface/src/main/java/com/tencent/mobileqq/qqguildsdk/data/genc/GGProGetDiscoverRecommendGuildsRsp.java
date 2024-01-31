package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProGetDiscoverRecommendGuildsRsp;
import com.tencent.qqnt.kernel.nativeinterface.GProRecommendItem;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProGetDiscoverRecommendGuildsRsp implements IGProGetDiscoverRecommendGuildsRsp {
    public final GProGetDiscoverRecommendGuildsRsp mInfo;

    public GGProGetDiscoverRecommendGuildsRsp(GProGetDiscoverRecommendGuildsRsp gProGetDiscoverRecommendGuildsRsp) {
        this.mInfo = gProGetDiscoverRecommendGuildsRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetDiscoverRecommendGuildsRsp
    public byte[] getCookies() {
        return this.mInfo.getCookies();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetDiscoverRecommendGuildsRsp
    public boolean getIsEnd() {
        return this.mInfo.getIsEnd();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetDiscoverRecommendGuildsRsp
    public ArrayList<IGProRecommendItem> getItems() {
        ArrayList<GProRecommendItem> items = this.mInfo.getItems();
        ArrayList<IGProRecommendItem> arrayList = new ArrayList<>();
        Iterator<GProRecommendItem> it = items.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProRecommendItem(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetDiscoverRecommendGuildsRsp
    public String getMsg() {
        return this.mInfo.getMsg();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetDiscoverRecommendGuildsRsp
    public String getRequestId() {
        return this.mInfo.getRequestId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetDiscoverRecommendGuildsRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
