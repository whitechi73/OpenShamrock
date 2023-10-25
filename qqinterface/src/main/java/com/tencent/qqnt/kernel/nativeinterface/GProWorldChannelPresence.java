package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProWorldChannelPresence implements Serializable {
    String cover;
    int historyMemberTotal;
    String schema;
    long serialVersionUID;

    public GProWorldChannelPresence() {
        this.serialVersionUID = 1L;
        this.cover = "";
        this.schema = "";
    }

    public String getCover() {
        return this.cover;
    }

    public int getHistoryMemberTotal() {
        return this.historyMemberTotal;
    }

    public String getSchema() {
        return this.schema;
    }

    public String toString() {
        return "GProWorldChannelPresence{cover=" + this.cover + ",schema=" + this.schema + ",historyMemberTotal=" + this.historyMemberTotal + ",}";
    }

    public GProWorldChannelPresence(String str, String str2, int i2) {
        this.serialVersionUID = 1L;
        this.cover = "";
        this.schema = "";
        this.cover = str;
        this.schema = str2;
        this.historyMemberTotal = i2;
    }
}
