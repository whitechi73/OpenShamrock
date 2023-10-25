package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public final class GrayTipMember implements Serializable {
    String name;
    long serialVersionUID;
    String uid;

    public GrayTipMember() {
        this.serialVersionUID = 1L;
        this.uid = "";
        this.name = "";
    }

    public String getName() {
        return this.name;
    }

    public String getUid() {
        return this.uid;
    }

    public String toString() {
        return "GrayTipMember{uid=" + this.uid + ",name=" + this.name + ",}";
    }

    public GrayTipMember(String str, String str2) {
        this.serialVersionUID = 1L;
        this.uid = "";
        this.name = "";
        this.uid = str;
        this.name = str2;
    }
}