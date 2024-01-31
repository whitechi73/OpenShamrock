package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProSlowModeInfo;

import java.io.Serializable;

public  class GGProSlowModeInfo implements Serializable {
    public final GProSlowModeInfo mInfo;

    public GGProSlowModeInfo(GProSlowModeInfo gProSlowModeInfo) {
        this.mInfo = gProSlowModeInfo;
    }

    public int getSlowModeCircle() {
        return this.mInfo.getSlowModeCircle();
    }

    public int getSlowModeKey() {
        return this.mInfo.getSlowModeKey();
    }

    public String getSlowModeText() {
        return this.mInfo.getSlowModeText();
    }

    public int getSpeakFrequency() {
        return this.mInfo.getSpeakFrequency();
    }

    public String toString() {
        return this.mInfo.toString();
    }
}
