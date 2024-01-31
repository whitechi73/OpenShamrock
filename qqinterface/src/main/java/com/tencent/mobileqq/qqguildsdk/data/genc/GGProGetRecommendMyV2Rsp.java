package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProGetRecommendMyV2Rsp;
import com.tencent.qqnt.kernel.nativeinterface.GProRecommendItem;

import java.util.ArrayList;
import java.util.Iterator;


public class GGProGetRecommendMyV2Rsp implements IGProGetRecommendMyV2Rsp {
    public final GProGetRecommendMyV2Rsp mInfo;

    public GGProGetRecommendMyV2Rsp(GProGetRecommendMyV2Rsp gProGetRecommendMyV2Rsp) {
        this.mInfo = gProGetRecommendMyV2Rsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRecommendMyV2Rsp
    public IGProGetAtMeMsgRsp getAtMeMsg() {
        return new GGProGetAtMeMsgRsp(this.mInfo.getAtMeMsg());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRecommendMyV2Rsp
    public byte[] getCookies() {
        return this.mInfo.getCookies();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRecommendMyV2Rsp
    public IGProRecommendExtInfo getExtInfo() {
        return new GGProRecommendExtInfo(this.mInfo.getExtInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRecommendMyV2Rsp
    public ArrayList<IGProRecommendItem> getRecommendList() {
        ArrayList<GProRecommendItem> recommendList = this.mInfo.getRecommendList();
        ArrayList<IGProRecommendItem> arrayList = new ArrayList<>();
        Iterator<GProRecommendItem> it = recommendList.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProRecommendItem(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRecommendMyV2Rsp
    public String toString() {
        return this.mInfo.toString();
    }
}
