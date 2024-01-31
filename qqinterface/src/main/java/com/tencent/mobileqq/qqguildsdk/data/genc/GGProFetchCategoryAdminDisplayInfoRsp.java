package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProCategoryAdminDisplayInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProFetchCategoryAdminDisplayInfoRsp;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProFetchCategoryAdminDisplayInfoRsp implements IGProFetchCategoryAdminDisplayInfoRsp {
    public final GProFetchCategoryAdminDisplayInfoRsp mInfo;

    public GGProFetchCategoryAdminDisplayInfoRsp(GProFetchCategoryAdminDisplayInfoRsp gProFetchCategoryAdminDisplayInfoRsp) {
        this.mInfo = gProFetchCategoryAdminDisplayInfoRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProFetchCategoryAdminDisplayInfoRsp
    public ArrayList<IGProCategoryAdminDisplayInfo> getCategoryAdminDisplayList() {
        ArrayList<GProCategoryAdminDisplayInfo> categoryAdminDisplayList = this.mInfo.getCategoryAdminDisplayList();
        ArrayList<IGProCategoryAdminDisplayInfo> arrayList = new ArrayList<>();
        Iterator<GProCategoryAdminDisplayInfo> it = categoryAdminDisplayList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProCategoryAdminDisplayInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProFetchCategoryAdminDisplayInfoRsp
    public int getCategoryAdminMaxNum() {
        return this.mInfo.getCategoryAdminMaxNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProFetchCategoryAdminDisplayInfoRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
