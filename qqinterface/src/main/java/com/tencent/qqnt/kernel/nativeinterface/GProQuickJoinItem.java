package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

public  final class GProQuickJoinItem implements Serializable {
    String coverUrl;
    ArrayList<String> membersAvatar;
    String name;
    String onlineNumTag;
    int order;
    long serialVersionUID;
    int statusTag;
    int voiceType;

    public GProQuickJoinItem() {
        this.serialVersionUID = 1L;
        this.name = "";
        this.coverUrl = "";
        this.onlineNumTag = "";
        this.membersAvatar = new ArrayList<>();
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public ArrayList<String> getMembersAvatar() {
        return this.membersAvatar;
    }

    public String getName() {
        return this.name;
    }

    public String getOnlineNumTag() {
        return this.onlineNumTag;
    }

    public int getOrder() {
        return this.order;
    }

    public int getStatusTag() {
        return this.statusTag;
    }

    public int getVoiceType() {
        return this.voiceType;
    }

    public String toString() {
        return "GProQuickJoinItem{name=" + this.name + ",voiceType=" + this.voiceType + ",coverUrl=" + this.coverUrl + ",onlineNumTag=" + this.onlineNumTag + ",membersAvatar=" + this.membersAvatar + ",statusTag=" + this.statusTag + ",order=" + this.order + ",}";
    }

    public GProQuickJoinItem(String str, int i2, String str2, String str3, ArrayList<String> arrayList, int i3, int i4) {
        this.serialVersionUID = 1L;
        this.name = "";
        this.coverUrl = "";
        this.onlineNumTag = "";
        this.membersAvatar = new ArrayList<>();
        this.name = str;
        this.voiceType = i2;
        this.coverUrl = str2;
        this.onlineNumTag = str3;
        this.membersAvatar = arrayList;
        this.statusTag = i3;
        this.order = i4;
    }
}
