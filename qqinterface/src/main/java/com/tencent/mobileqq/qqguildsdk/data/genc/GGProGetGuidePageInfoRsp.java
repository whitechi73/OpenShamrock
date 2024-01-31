package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProGetGuidePageInfoRsp;
import com.tencent.qqnt.kernel.nativeinterface.GProGuidePageInfo;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProGetGuidePageInfoRsp implements IGProGetGuidePageInfoRsp {
    public final GProGetGuidePageInfoRsp mInfo;

    public GGProGetGuidePageInfoRsp(GProGetGuidePageInfoRsp gProGetGuidePageInfoRsp) {
        this.mInfo = gProGetGuidePageInfoRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetGuidePageInfoRsp
    public ArrayList<IGProGuidePageInfo> getGuidePage() {
        ArrayList<GProGuidePageInfo> guidePage = this.mInfo.getGuidePage();
        ArrayList<IGProGuidePageInfo> arrayList = new ArrayList<>();
        Iterator<GProGuidePageInfo> it = guidePage.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProGuidePageInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetGuidePageInfoRsp
    public IGProGuidePageInfo getMainGuidePage() {
        return new GGProGuidePageInfo(this.mInfo.getMainGuidePage());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetGuidePageInfoRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
