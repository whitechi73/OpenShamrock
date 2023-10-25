package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProClientShowCfg {
    ArrayList<GProConfigItem> configItem;

    public GProClientShowCfg() {
        this.configItem = new ArrayList<>();
    }

    public ArrayList<GProConfigItem> getConfigItem() {
        return this.configItem;
    }

    public String toString() {
        return "GProClientShowCfg{configItem=" + this.configItem + ",}";
    }

    public GProClientShowCfg(ArrayList<GProConfigItem> arrayList) {
        this.configItem = new ArrayList<>();
        this.configItem = arrayList;
    }
}
