package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProWorldPresence0x11bc implements Serializable {
    String coverUrl;
    long serialVersionUID;

    public GProWorldPresence0x11bc() {
        this.serialVersionUID = 1L;
        this.coverUrl = "";
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public String toString() {
        return "GProWorldPresence0x11bc{coverUrl=" + this.coverUrl + ",}";
    }

    public GProWorldPresence0x11bc(String str) {
        this.serialVersionUID = 1L;
        this.coverUrl = "";
        this.coverUrl = str;
    }
}
