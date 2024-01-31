package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public  final class GProUserAllGiftInfo implements Serializable {
    GProUserGiftInfo freeGiftInfo;
    GProUserGiftInfo payGiftInfo;
    long serialVersionUID;

    public GProUserAllGiftInfo() {
        this.serialVersionUID = 1L;
        this.payGiftInfo = new GProUserGiftInfo();
        this.freeGiftInfo = new GProUserGiftInfo();
    }

    public GProUserGiftInfo getFreeGiftInfo() {
        return this.freeGiftInfo;
    }

    public GProUserGiftInfo getPayGiftInfo() {
        return this.payGiftInfo;
    }

    public String toString() {
        return "GProUserAllGiftInfo{payGiftInfo=" + this.payGiftInfo + ",freeGiftInfo=" + this.freeGiftInfo + ",}";
    }

    public GProUserAllGiftInfo(GProUserGiftInfo gProUserGiftInfo, GProUserGiftInfo gProUserGiftInfo2) {
        this.serialVersionUID = 1L;
        this.payGiftInfo = new GProUserGiftInfo();
        this.freeGiftInfo = new GProUserGiftInfo();
        this.payGiftInfo = gProUserGiftInfo;
        this.freeGiftInfo = gProUserGiftInfo2;
    }
}
