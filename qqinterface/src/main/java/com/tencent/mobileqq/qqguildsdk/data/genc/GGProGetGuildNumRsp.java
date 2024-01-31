package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProGetGuildNumRsp;

public  class GGProGetGuildNumRsp implements IGProGetGuildNumRsp {
    public final GProGetGuildNumRsp mInfo;

    public GGProGetGuildNumRsp(GProGetGuildNumRsp gProGetGuildNumRsp) {
        this.mInfo = gProGetGuildNumRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetGuildNumRsp
    public IGProGuildNumInfo getGuildNumInfo() {
        return new GGProGuildNumInfo(this.mInfo.getGuildNumInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetGuildNumRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
