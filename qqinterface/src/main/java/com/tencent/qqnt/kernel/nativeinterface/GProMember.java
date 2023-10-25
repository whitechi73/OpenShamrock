package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProMember implements Serializable {
    String name;
    long serialVersionUID;
    long tinyId;

    public GProMember() {
        this.serialVersionUID = 1L;
        this.name = "";
    }

    public String getName() {
        return this.name;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public String toString() {
        return "GProMember{tinyId=" + this.tinyId + ",name=" + this.name + ",}";
    }

    public GProMember(long j2, String str) {
        this.serialVersionUID = 1L;
        this.name = "";
        this.tinyId = j2;
        this.name = str;
    }
}
