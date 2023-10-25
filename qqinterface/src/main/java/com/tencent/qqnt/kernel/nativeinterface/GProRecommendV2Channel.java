package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProRecommendV2Channel implements Serializable {
    long browseTimeStamp;
    String coverUrl;
    String guildIcon;
    long guildId;
    String guildName;
    String guildProfile;
    String joinGuildSig;
    int joinedGuild;
    ArrayList<GProRecommendV2Label> labelList;
    int memberRole;
    long ownerUin;
    long serialVersionUID;
    ArrayList<GProRecommendGuildState> stateList;
    ArrayList<String> tagList;
    long uniqueId;

    public GProRecommendV2Channel() {
        this.serialVersionUID = 1L;
        this.guildName = "";
        this.guildProfile = "";
        this.guildIcon = "";
        this.stateList = new ArrayList<>();
        this.tagList = new ArrayList<>();
        this.coverUrl = "";
        this.joinGuildSig = "";
        this.labelList = new ArrayList<>();
    }

    public long getBrowseTimeStamp() {
        return this.browseTimeStamp;
    }

    public String getCoverUrl() {
        return this.coverUrl;
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

    public String getJoinGuildSig() {
        return this.joinGuildSig;
    }

    public int getJoinedGuild() {
        return this.joinedGuild;
    }

    public ArrayList<GProRecommendV2Label> getLabelList() {
        return this.labelList;
    }

    public int getMemberRole() {
        return this.memberRole;
    }

    public long getOwnerUin() {
        return this.ownerUin;
    }

    public ArrayList<GProRecommendGuildState> getStateList() {
        return this.stateList;
    }

    public ArrayList<String> getTagList() {
        return this.tagList;
    }

    public long getUniqueId() {
        return this.uniqueId;
    }

    public String toString() {
        return "GProRecommendV2Channel{guildId=" + this.guildId + ",guildName=" + this.guildName + ",guildProfile=" + this.guildProfile + ",guildIcon=" + this.guildIcon + ",stateList=" + this.stateList + ",tagList=" + this.tagList + ",joinedGuild=" + this.joinedGuild + ",coverUrl=" + this.coverUrl + ",joinGuildSig=" + this.joinGuildSig + ",memberRole=" + this.memberRole + ",browseTimeStamp=" + this.browseTimeStamp + ",ownerUin=" + this.ownerUin + ",uniqueId=" + this.uniqueId + ",labelList=" + this.labelList + ",}";
    }

    public GProRecommendV2Channel(long j2, String str, String str2, String str3, ArrayList<GProRecommendGuildState> arrayList, ArrayList<String> arrayList2, int i2, String str4, String str5, int i3, long j3, long j4, long j5, ArrayList<GProRecommendV2Label> arrayList3) {
        this.serialVersionUID = 1L;
        this.guildName = "";
        this.guildProfile = "";
        this.guildIcon = "";
        this.stateList = new ArrayList<>();
        this.tagList = new ArrayList<>();
        this.coverUrl = "";
        this.joinGuildSig = "";
        this.labelList = new ArrayList<>();
        this.guildId = j2;
        this.guildName = str;
        this.guildProfile = str2;
        this.guildIcon = str3;
        this.stateList = arrayList;
        this.tagList = arrayList2;
        this.joinedGuild = i2;
        this.coverUrl = str4;
        this.joinGuildSig = str5;
        this.memberRole = i3;
        this.browseTimeStamp = j3;
        this.ownerUin = j4;
        this.uniqueId = j5;
        this.labelList = arrayList3;
    }
}
