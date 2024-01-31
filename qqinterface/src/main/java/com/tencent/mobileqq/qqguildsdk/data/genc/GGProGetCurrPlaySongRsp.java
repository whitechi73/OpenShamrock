package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProGetCurrPlaySongRsp;

public  class GGProGetCurrPlaySongRsp implements IGProGetCurrPlaySongRsp {
    public final GProGetCurrPlaySongRsp mInfo;

    public GGProGetCurrPlaySongRsp(GProGetCurrPlaySongRsp gProGetCurrPlaySongRsp) {
        this.mInfo = gProGetCurrPlaySongRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetCurrPlaySongRsp
    public IGProPlayInfo getPlayInfo() {
        return new GGProPlayInfo(this.mInfo.getPlayInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetCurrPlaySongRsp
    public IGProListenTogetherRspHead getRspHead() {
        return new GGProListenTogetherRspHead(this.mInfo.getRspHead());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetCurrPlaySongRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
