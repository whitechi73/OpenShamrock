package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public  final class GProUserGiftInfo implements Serializable {
    long giftPrice;
    String giftTipsMsg;
    long serialVersionUID;
    String showGiftPrice;

    public GProUserGiftInfo() {
        this.serialVersionUID = 1L;
        this.showGiftPrice = "";
        this.giftTipsMsg = "";
    }

    public long getGiftPrice() {
        return this.giftPrice;
    }

    public String getGiftTipsMsg() {
        return this.giftTipsMsg;
    }

    public String getShowGiftPrice() {
        return this.showGiftPrice;
    }

    public String toString() {
        return "GProUserGiftInfo{giftPrice=" + this.giftPrice + ",showGiftPrice=" + this.showGiftPrice + ",giftTipsMsg=" + this.giftTipsMsg + ",}";
    }

    public GProUserGiftInfo(long j2, String str, String str2) {
        this.serialVersionUID = 1L;
        this.showGiftPrice = "";
        this.giftTipsMsg = "";
        this.giftPrice = j2;
        this.showGiftPrice = str;
        this.giftTipsMsg = str2;
    }
}
