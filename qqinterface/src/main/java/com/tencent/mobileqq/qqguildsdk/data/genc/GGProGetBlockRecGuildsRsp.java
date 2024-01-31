package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProBlockInfo;
import com.tencent.qqnt.kernel.nativeinterface.GProGetBlockRecGuildsRsp;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProGetBlockRecGuildsRsp implements IGProGetBlockRecGuildsRsp {
    public final GProGetBlockRecGuildsRsp mInfo;

    public GGProGetBlockRecGuildsRsp(GProGetBlockRecGuildsRsp gProGetBlockRecGuildsRsp) {
        this.mInfo = gProGetBlockRecGuildsRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetBlockRecGuildsRsp
    public IGProGetRecommendV2Rsp getBanner() {
        return new GGProGetRecommendV2Rsp(this.mInfo.getBanner());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetBlockRecGuildsRsp
    public byte[] getCookies() {
        return this.mInfo.getCookies();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetBlockRecGuildsRsp
    public boolean getIsEnd() {
        return this.mInfo.getIsEnd();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetBlockRecGuildsRsp
    public String getMsg() {
        return this.mInfo.getMsg();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetBlockRecGuildsRsp
    public ArrayList<IGProBlockInfo> getRecBlockInfo() {
        ArrayList<GProBlockInfo> recBlockInfo = this.mInfo.getRecBlockInfo();
        ArrayList<IGProBlockInfo> arrayList = new ArrayList<>();
        Iterator<GProBlockInfo> it = recBlockInfo.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProBlockInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetBlockRecGuildsRsp
    public String getTraceId() {
        return this.mInfo.getTraceId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetBlockRecGuildsRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
