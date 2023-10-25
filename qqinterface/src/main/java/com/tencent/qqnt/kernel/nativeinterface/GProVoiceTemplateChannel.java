package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProVoiceTemplateChannel implements Serializable {
    GProRecommendCoverInfo cover;
    int currentNum;
    String icon;
    int maxNum;
    ArrayList<GProMemberInfo> members;
    String name;
    String playDesc;
    long serialVersionUID;
    int status;
    String statusDesc;
    String statusIcon;

    public GProVoiceTemplateChannel() {
        this.serialVersionUID = 1L;
        this.cover = new GProRecommendCoverInfo();
        this.statusDesc = "";
        this.statusIcon = "";
        this.members = new ArrayList<>();
        this.name = "";
        this.icon = "";
        this.playDesc = "";
    }

    public GProRecommendCoverInfo getCover() {
        return this.cover;
    }

    public int getCurrentNum() {
        return this.currentNum;
    }

    public String getIcon() {
        return this.icon;
    }

    public int getMaxNum() {
        return this.maxNum;
    }

    public ArrayList<GProMemberInfo> getMembers() {
        return this.members;
    }

    public String getName() {
        return this.name;
    }

    public String getPlayDesc() {
        return this.playDesc;
    }

    public int getStatus() {
        return this.status;
    }

    public String getStatusDesc() {
        return this.statusDesc;
    }

    public String getStatusIcon() {
        return this.statusIcon;
    }

    public String toString() {
        return "GProVoiceTemplateChannel{cover=" + this.cover + ",statusDesc=" + this.statusDesc + ",statusIcon=" + this.statusIcon + ",members=" + this.members + ",name=" + this.name + ",status=" + this.status + ",icon=" + this.icon + ",playDesc=" + this.playDesc + ",currentNum=" + this.currentNum + ",maxNum=" + this.maxNum + ",}";
    }

    public GProVoiceTemplateChannel(GProRecommendCoverInfo gProRecommendCoverInfo, String str, String str2, ArrayList<GProMemberInfo> arrayList, String str3, int i2, String str4, String str5, int i3, int i4) {
        this.serialVersionUID = 1L;
        this.cover = new GProRecommendCoverInfo();
        this.statusDesc = "";
        this.statusIcon = "";
        this.members = new ArrayList<>();
        this.name = "";
        this.icon = "";
        this.playDesc = "";
        this.cover = gProRecommendCoverInfo;
        this.statusDesc = str;
        this.statusIcon = str2;
        this.members = arrayList;
        this.name = str3;
        this.status = i2;
        this.icon = str4;
        this.playDesc = str5;
        this.currentNum = i3;
        this.maxNum = i4;
    }
}
