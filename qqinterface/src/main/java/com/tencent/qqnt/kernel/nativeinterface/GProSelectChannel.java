package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProSelectChannel {
    ArrayList<Long> guildIds;
    String labelName;

    public GProSelectChannel() {
        this.labelName = "";
        this.guildIds = new ArrayList<>();
    }

    public ArrayList<Long> getGuildIds() {
        return this.guildIds;
    }

    public String getLabelName() {
        return this.labelName;
    }

    public String toString() {
        return "GProSelectChannel{labelName=" + this.labelName + ",guildIds=" + this.guildIds + ",}";
    }

    public GProSelectChannel(String str, ArrayList<Long> arrayList) {
        this.labelName = "";
        this.guildIds = new ArrayList<>();
        this.labelName = str;
        this.guildIds = arrayList;
    }
}
