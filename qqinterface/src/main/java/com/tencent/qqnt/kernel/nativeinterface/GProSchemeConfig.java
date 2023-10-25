package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProSchemeConfig implements Serializable {
    String schema;
    long serialVersionUID;
    String text;

    public GProSchemeConfig() {
        this.serialVersionUID = 1L;
        this.schema = "";
        this.text = "";
    }

    public String getSchema() {
        return this.schema;
    }

    public String getText() {
        return this.text;
    }

    public String toString() {
        return "GProSchemeConfig{schema=" + this.schema + ",text=" + this.text + ",}";
    }

    public GProSchemeConfig(String str, String str2) {
        this.serialVersionUID = 1L;
        this.schema = "";
        this.text = "";
        this.schema = str;
        this.text = str2;
    }
}
