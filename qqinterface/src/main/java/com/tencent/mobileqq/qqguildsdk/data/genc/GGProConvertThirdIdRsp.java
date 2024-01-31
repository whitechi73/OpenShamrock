package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProConvertThirdIdRsp;

import java.util.ArrayList;

public  class GGProConvertThirdIdRsp implements IGProConvertThirdIdRsp {
    public final GProConvertThirdIdRsp mInfo;

    public GGProConvertThirdIdRsp(GProConvertThirdIdRsp gProConvertThirdIdRsp) {
        this.mInfo = gProConvertThirdIdRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProConvertThirdIdRsp
    public ArrayList<String> getIds() {
        return this.mInfo.getIds();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProConvertThirdIdRsp
    public ArrayList<String> getStringIds() {
        return this.mInfo.getStringIds();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProConvertThirdIdRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
