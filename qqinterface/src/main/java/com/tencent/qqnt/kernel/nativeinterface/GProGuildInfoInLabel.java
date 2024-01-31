package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

public  final class GProGuildInfoInLabel implements Serializable {
    String guildIcon;
    long guildId;
    ArrayList<String> guildLabels;
    String guildName;
    int guildStatus;
    String joinGuildSig;
    long serialVersionUID;

    public GProGuildInfoInLabel() {
        this.serialVersionUID = 1L;
        this.guildName = "";
        this.guildIcon = "";
        this.guildLabels = new ArrayList<>();
        this.joinGuildSig = "";
    }

    public String getGuildIcon() {
        return this.guildIcon;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public ArrayList<String> getGuildLabels() {
        return this.guildLabels;
    }

    public String getGuildName() {
        return this.guildName;
    }

    public int getGuildStatus() {
        return this.guildStatus;
    }

    public String getJoinGuildSig() {
        return this.joinGuildSig;
    }

    public String toString() {
        return "GProGuildInfoInLabel{guildId=" + this.guildId + ",guildName=" + this.guildName + ",guildIcon=" + this.guildIcon + ",guildLabels=" + this.guildLabels + ",guildStatus=" + this.guildStatus + ",joinGuildSig=" + this.joinGuildSig + ",}";
    }

    public GProGuildInfoInLabel(long j2, String str, String str2, ArrayList<String> arrayList, int i2, String str3) {
        this.serialVersionUID = 1L;
        this.guildName = "";
        this.guildIcon = "";
        this.guildLabels = new ArrayList<>();
        this.joinGuildSig = "";
        this.guildId = j2;
        this.guildName = str;
        this.guildIcon = str2;
        this.guildLabels = arrayList;
        this.guildStatus = i2;
        this.joinGuildSig = str3;
    }
}
