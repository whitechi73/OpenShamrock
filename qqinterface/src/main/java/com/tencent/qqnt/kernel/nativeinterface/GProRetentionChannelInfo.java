package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

public  final class GProRetentionChannelInfo implements Serializable {
    String guildCover;
    String guildIcon;
    long guildId;
    String guildName;
    String guildProfile;
    String joinSig;
    long serialVersionUID;
    ArrayList<GProRetentionChannelLabel> tagList;

    public GProRetentionChannelInfo() {
        this.serialVersionUID = 1L;
        this.guildName = "";
        this.guildIcon = "";
        this.guildProfile = "";
        this.guildCover = "";
        this.joinSig = "";
        this.tagList = new ArrayList<>();
    }

    public String getGuildCover() {
        return this.guildCover;
    }

    public String getGuildIcon() {
        return this.guildIcon;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getGuildName() {
        return this.guildName;
    }

    public String getGuildProfile() {
        return this.guildProfile;
    }

    public String getJoinSig() {
        return this.joinSig;
    }

    public ArrayList<GProRetentionChannelLabel> getTagList() {
        return this.tagList;
    }

    public String toString() {
        return "GProRetentionChannelInfo{guildId=" + this.guildId + ",guildName=" + this.guildName + ",guildIcon=" + this.guildIcon + ",guildProfile=" + this.guildProfile + ",guildCover=" + this.guildCover + ",joinSig=" + this.joinSig + ",tagList=" + this.tagList + ",}";
    }

    public GProRetentionChannelInfo(long j2, String str, String str2, String str3, String str4, String str5, ArrayList<GProRetentionChannelLabel> arrayList) {
        this.serialVersionUID = 1L;
        this.guildName = "";
        this.guildIcon = "";
        this.guildProfile = "";
        this.guildCover = "";
        this.joinSig = "";
        this.tagList = new ArrayList<>();
        this.guildId = j2;
        this.guildName = str;
        this.guildIcon = str2;
        this.guildProfile = str3;
        this.guildCover = str4;
        this.joinSig = str5;
        this.tagList = arrayList;
    }
}
