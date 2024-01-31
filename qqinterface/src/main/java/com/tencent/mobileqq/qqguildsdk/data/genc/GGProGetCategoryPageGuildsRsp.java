package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProGetCategoryPageGuildsRsp;
import com.tencent.qqnt.kernel.nativeinterface.GProRecommendCategory;
import com.tencent.qqnt.kernel.nativeinterface.GProRecommendItem;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProGetCategoryPageGuildsRsp implements IGProGetCategoryPageGuildsRsp {
    public final GProGetCategoryPageGuildsRsp mInfo;

    public GGProGetCategoryPageGuildsRsp(GProGetCategoryPageGuildsRsp gProGetCategoryPageGuildsRsp) {
        this.mInfo = gProGetCategoryPageGuildsRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetCategoryPageGuildsRsp
    public ArrayList<IGProRecommendCategory> getCategories() {
        ArrayList<GProRecommendCategory> categories = this.mInfo.getCategories();
        ArrayList<IGProRecommendCategory> arrayList = new ArrayList<>();
        Iterator<GProRecommendCategory> it = categories.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProRecommendCategory(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetCategoryPageGuildsRsp
    public boolean getIsEnd() {
        return this.mInfo.getIsEnd();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetCategoryPageGuildsRsp
    public ArrayList<IGProRecommendItem> getItems() {
        ArrayList<GProRecommendItem> items = this.mInfo.getItems();
        ArrayList<IGProRecommendItem> arrayList = new ArrayList<>();
        Iterator<GProRecommendItem> it = items.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProRecommendItem(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetCategoryPageGuildsRsp
    public String getTraceId() {
        return this.mInfo.getTraceId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetCategoryPageGuildsRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
