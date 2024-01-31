package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProGetCategoryGuildsRsp;
import com.tencent.qqnt.kernel.nativeinterface.GProRecommendItem;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProGetCategoryGuildsRsp implements IGProGetCategoryGuildsRsp {
    public final GProGetCategoryGuildsRsp mInfo;

    public GGProGetCategoryGuildsRsp(GProGetCategoryGuildsRsp gProGetCategoryGuildsRsp) {
        this.mInfo = gProGetCategoryGuildsRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetCategoryGuildsRsp
    public byte[] getCookies() {
        return this.mInfo.getCookies();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetCategoryGuildsRsp
    public boolean getIsEnd() {
        return this.mInfo.getIsEnd();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetCategoryGuildsRsp
    public ArrayList<IGProRecommendItem> getItems() {
        ArrayList<GProRecommendItem> items = this.mInfo.getItems();
        ArrayList<IGProRecommendItem> arrayList = new ArrayList<>();
        Iterator<GProRecommendItem> it = items.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProRecommendItem(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetCategoryGuildsRsp
    public String getMsg() {
        return this.mInfo.getMsg();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetCategoryGuildsRsp
    public String getTraceId() {
        return this.mInfo.getTraceId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetCategoryGuildsRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
