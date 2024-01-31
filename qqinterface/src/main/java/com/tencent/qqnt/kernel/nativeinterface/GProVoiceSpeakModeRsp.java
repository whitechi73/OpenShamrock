package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProVoiceSpeakModeRsp {
    String confirmExt;
    String confirmMsg;
    int modCode;

    public GProVoiceSpeakModeRsp() {
        this.confirmMsg = "";
        this.confirmExt = "";
    }

    public String getConfirmExt() {
        return this.confirmExt;
    }

    public String getConfirmMsg() {
        return this.confirmMsg;
    }

    public int getModCode() {
        return this.modCode;
    }

    public String toString() {
        return "GProVoiceSpeakModeRsp{modCode=" + this.modCode + ",confirmMsg=" + this.confirmMsg + ",confirmExt=" + this.confirmExt + ",}";
    }

    public GProVoiceSpeakModeRsp(int i2, String str, String str2) {
        this.confirmMsg = "";
        this.confirmExt = "";
        this.modCode = i2;
        this.confirmMsg = str;
        this.confirmExt = str2;
    }
}
