package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProBatchGetBlockItemRsp;
import com.tencent.qqnt.kernel.nativeinterface.GProBlockInfo;

import java.util.ArrayList;
import java.util.Iterator;

public  class GGProBatchGetBlockItemRsp implements IGProBatchGetBlockItemRsp {
    public final GProBatchGetBlockItemRsp mInfo;

    public GGProBatchGetBlockItemRsp(GProBatchGetBlockItemRsp gProBatchGetBlockItemRsp) {
        this.mInfo = gProBatchGetBlockItemRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBatchGetBlockItemRsp
    public byte[] getCookies() {
        return this.mInfo.getCookies();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBatchGetBlockItemRsp
    public boolean getIsEnd() {
        return this.mInfo.getIsEnd();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBatchGetBlockItemRsp
    public ArrayList<IGProBlockInfo> getItems() {
        ArrayList<GProBlockInfo> items = this.mInfo.getItems();
        ArrayList<IGProBlockInfo> arrayList = new ArrayList<>();
        Iterator<GProBlockInfo> it = items.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProBlockInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBatchGetBlockItemRsp
    public String getMsg() {
        return this.mInfo.getMsg();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBatchGetBlockItemRsp
    public String getTraceId() {
        return this.mInfo.getTraceId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBatchGetBlockItemRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
