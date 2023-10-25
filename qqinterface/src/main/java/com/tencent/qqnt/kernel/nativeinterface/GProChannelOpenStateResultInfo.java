package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProChannelOpenStateResultInfo implements Serializable {
    boolean peakActivityGuildFlag;
    long serialVersionUID;
    ArrayList<GProSwitchInfo> switchInfoList;

    public GProChannelOpenStateResultInfo() {
        this.serialVersionUID = 1L;
        this.switchInfoList = new ArrayList<>();
    }

    public boolean getPeakActivityGuildFlag() {
        return this.peakActivityGuildFlag;
    }

    public ArrayList<GProSwitchInfo> getSwitchInfoList() {
        return this.switchInfoList;
    }

    public String toString() {
        return "GProChannelOpenStateResultInfo{switchInfoList=" + this.switchInfoList + ",peakActivityGuildFlag=" + this.peakActivityGuildFlag + ",}";
    }

    public GProChannelOpenStateResultInfo(ArrayList<GProSwitchInfo> arrayList, boolean z) {
        this.serialVersionUID = 1L;
        this.switchInfoList = new ArrayList<>();
        this.switchInfoList = arrayList;
        this.peakActivityGuildFlag = z;
    }
}
