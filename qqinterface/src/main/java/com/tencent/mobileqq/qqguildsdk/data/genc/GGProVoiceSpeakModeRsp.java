package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProVoiceSpeakModeRsp;


public class GGProVoiceSpeakModeRsp implements IGProVoiceSpeakModeRsp {
    public final GProVoiceSpeakModeRsp mInfo;

    public GGProVoiceSpeakModeRsp(GProVoiceSpeakModeRsp gProVoiceSpeakModeRsp) {
        this.mInfo = gProVoiceSpeakModeRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSpeakModeRsp
    public String getConfirmExt() {
        return this.mInfo.getConfirmExt();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSpeakModeRsp
    public String getConfirmMsg() {
        return this.mInfo.getConfirmMsg();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSpeakModeRsp
    public int getModCode() {
        return this.mInfo.getModCode();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceSpeakModeRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
