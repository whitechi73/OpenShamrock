package com.tencent.qqnt.kernel.nativeinterface;


public final class VASPersonalVipNumberInfo {
    Integer appId;
    Integer itemId;
    Integer numberIdx;
    Integer numberItemId;

    public VASPersonalVipNumberInfo() {
    }

    public Integer getAppId() {
        return this.appId;
    }

    public Integer getItemId() {
        return this.itemId;
    }

    public Integer getNumberIdx() {
        return this.numberIdx;
    }

    public Integer getNumberItemId() {
        return this.numberItemId;
    }

    public String toString() {
        return "VASPersonalVipNumberInfo{appId=" + this.appId + ",itemId=" + this.itemId + ",numberItemId=" + this.numberItemId + ",numberIdx=" + this.numberIdx + ",}";
    }

    public VASPersonalVipNumberInfo(Integer num, Integer num2, Integer num3, Integer num4) {
        this.appId = num;
        this.itemId = num2;
        this.numberItemId = num3;
        this.numberIdx = num4;
    }
}
