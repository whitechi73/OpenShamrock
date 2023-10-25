package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProGetGuildBindingInfoRsp {
    ArrayList<GProBriefAppInfo> bindableApps;
    ArrayList<GProBriefAppInfo> boundApps;

    public GProGetGuildBindingInfoRsp() {
        this.boundApps = new ArrayList<>();
        this.bindableApps = new ArrayList<>();
    }

    public ArrayList<GProBriefAppInfo> getBindableApps() {
        return this.bindableApps;
    }

    public ArrayList<GProBriefAppInfo> getBoundApps() {
        return this.boundApps;
    }

    public String toString() {
        return "GProGetGuildBindingInfoRsp{boundApps=" + this.boundApps + ",bindableApps=" + this.bindableApps + ",}";
    }

    public GProGetGuildBindingInfoRsp(ArrayList<GProBriefAppInfo> arrayList, ArrayList<GProBriefAppInfo> arrayList2) {
        this.boundApps = new ArrayList<>();
        this.bindableApps = new ArrayList<>();
        this.boundApps = arrayList;
        this.bindableApps = arrayList2;
    }
}
