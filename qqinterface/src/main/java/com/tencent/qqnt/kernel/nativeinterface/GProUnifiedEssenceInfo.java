package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProUnifiedEssenceInfo implements Serializable {
    ArrayList<GProEssenceChannel> channels;
    String content;
    Long operatorName;
    long serialVersionUID;
    Integer status;
    String title;
    Integer type;
    long uniqueId;
    String visitorMsg;

    public GProUnifiedEssenceInfo() {
        this.serialVersionUID = 1L;
        this.content = "";
        this.channels = new ArrayList<>();
        this.visitorMsg = "";
    }

    public ArrayList<GProEssenceChannel> getChannels() {
        return this.channels;
    }

    public String getContent() {
        return this.content;
    }

    public Long getOperatorName() {
        return this.operatorName;
    }

    public Integer getStatus() {
        return this.status;
    }

    public String getTitle() {
        return this.title;
    }

    public Integer getType() {
        return this.type;
    }

    public long getUniqueId() {
        return this.uniqueId;
    }

    public String getVisitorMsg() {
        return this.visitorMsg;
    }

    public String toString() {
        return "GProUnifiedEssenceInfo{type=" + this.type + ",title=" + this.title + ",content=" + this.content + ",operatorName=" + this.operatorName + ",channels=" + this.channels + ",status=" + this.status + ",uniqueId=" + this.uniqueId + ",visitorMsg=" + this.visitorMsg + ",}";
    }

    public GProUnifiedEssenceInfo(Integer num, String str, String str2, Long l2, ArrayList<GProEssenceChannel> arrayList, Integer num2, long j2, String str3) {
        this.serialVersionUID = 1L;
        this.content = "";
        this.channels = new ArrayList<>();
        this.visitorMsg = "";
        this.type = num;
        this.title = str;
        this.content = str2;
        this.operatorName = l2;
        this.channels = arrayList;
        this.status = num2;
        this.uniqueId = j2;
        this.visitorMsg = str3;
    }
}
