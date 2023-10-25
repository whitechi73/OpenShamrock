package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProProgrammeInfoReq {
    String programmeId;
    int tabType;

    public GProProgrammeInfoReq() {
        this.programmeId = "";
    }

    public String getProgrammeId() {
        return this.programmeId;
    }

    public int getTabType() {
        return this.tabType;
    }

    public String toString() {
        return "GProProgrammeInfoReq{programmeId=" + this.programmeId + ",tabType=" + this.tabType + ",}";
    }

    public GProProgrammeInfoReq(String str, int i2) {
        this.programmeId = "";
        this.programmeId = str;
        this.tabType = i2;
    }
}
