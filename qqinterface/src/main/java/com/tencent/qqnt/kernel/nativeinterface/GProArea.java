package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProArea {
    String areaId;
    String desc;

    public GProArea() {
        this.areaId = "";
        this.desc = "";
    }

    public String getAreaId() {
        return this.areaId;
    }

    public String getDesc() {
        return this.desc;
    }

    public String toString() {
        return "GProArea{areaId=" + this.areaId + ",desc=" + this.desc + ",}";
    }

    public GProArea(String str, String str2) {
        this.areaId = "";
        this.desc = "";
        this.areaId = str;
        this.desc = str2;
    }
}
