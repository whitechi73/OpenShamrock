package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes4.dex */
public final class GProOfficialMedalInfoExt implements Serializable {
    String iconUrl;
    boolean isOffical;
    long serialVersionUID;

    public GProOfficialMedalInfoExt() {
        this.serialVersionUID = 1L;
        this.iconUrl = "";
    }

    public String getIconUrl() {
        return this.iconUrl;
    }

    public boolean getIsOffical() {
        return this.isOffical;
    }

    public String toString() {
        return "GProOfficialMedalInfoExt{isOffical=" + this.isOffical + ",iconUrl=" + this.iconUrl + ",}";
    }

    public GProOfficialMedalInfoExt(boolean z, String str) {
        this.serialVersionUID = 1L;
        this.iconUrl = "";
        this.isOffical = z;
        this.iconUrl = str;
    }
}
