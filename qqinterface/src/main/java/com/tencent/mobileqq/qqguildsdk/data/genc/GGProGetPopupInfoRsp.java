package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProGetPopupInfoRsp;

public  class GGProGetPopupInfoRsp implements IGProGetPopupInfoRsp {
    public final GProGetPopupInfoRsp mInfo;

    public GGProGetPopupInfoRsp(GProGetPopupInfoRsp gProGetPopupInfoRsp) {
        this.mInfo = gProGetPopupInfoRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetPopupInfoRsp
    public String getButtonText() {
        return this.mInfo.getButtonText();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetPopupInfoRsp
    public String getFootText() {
        return this.mInfo.getFootText();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetPopupInfoRsp
    public String getGifUrl() {
        return this.mInfo.getGifUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetPopupInfoRsp
    public String getImgUrl() {
        return this.mInfo.getImgUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetPopupInfoRsp
    public String getTitle() {
        return this.mInfo.getTitle();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetPopupInfoRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
