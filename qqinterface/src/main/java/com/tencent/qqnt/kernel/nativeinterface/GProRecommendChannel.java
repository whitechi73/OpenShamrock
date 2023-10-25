package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProRecommendChannel implements Serializable {
    long channelId;
    String coverUrl;
    String icon;
    String joinGuildSig;
    int joinedGuild;
    String name;
    String profile;
    long serialVersionUID;
    ArrayList<GProGuildChannelState> stateList;
    ArrayList<String> tagList;

    public GProRecommendChannel() {
        this.serialVersionUID = 1L;
        this.name = "";
        this.profile = "";
        this.icon = "";
        this.stateList = new ArrayList<>();
        this.tagList = new ArrayList<>();
        this.coverUrl = "";
        this.joinGuildSig = "";
    }

    public long getChannelId() {
        return this.channelId;
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getJoinGuildSig() {
        return this.joinGuildSig;
    }

    public int getJoinedGuild() {
        return this.joinedGuild;
    }

    public String getName() {
        return this.name;
    }

    public String getProfile() {
        return this.profile;
    }

    public ArrayList<GProGuildChannelState> getStateList() {
        return this.stateList;
    }

    public ArrayList<String> getTagList() {
        return this.tagList;
    }

    public String toString() {
        return "GProRecommendChannel{channelId=" + this.channelId + ",name=" + this.name + ",profile=" + this.profile + ",icon=" + this.icon + ",stateList=" + this.stateList + ",tagList=" + this.tagList + ",joinedGuild=" + this.joinedGuild + ",coverUrl=" + this.coverUrl + ",joinGuildSig=" + this.joinGuildSig + ",}";
    }

    public GProRecommendChannel(long j2, String str, String str2, String str3, ArrayList<GProGuildChannelState> arrayList, ArrayList<String> arrayList2, int i2, String str4, String str5) {
        this.serialVersionUID = 1L;
        this.name = "";
        this.profile = "";
        this.icon = "";
        this.stateList = new ArrayList<>();
        this.tagList = new ArrayList<>();
        this.coverUrl = "";
        this.joinGuildSig = "";
        this.channelId = j2;
        this.name = str;
        this.profile = str2;
        this.icon = str3;
        this.stateList = arrayList;
        this.tagList = arrayList2;
        this.joinedGuild = i2;
        this.coverUrl = str4;
        this.joinGuildSig = str5;
    }
}
