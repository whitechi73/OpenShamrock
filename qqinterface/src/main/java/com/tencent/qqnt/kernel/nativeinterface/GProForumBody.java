package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProForumBody {
    int everyHours;
    ArrayList<GProForumChannel> forumChannel;
    String requestId;
    long updateTime;

    public GProForumBody() {
        this.forumChannel = new ArrayList<>();
        this.requestId = "";
    }

    public int getEveryHours() {
        return this.everyHours;
    }

    public ArrayList<GProForumChannel> getForumChannel() {
        return this.forumChannel;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public String toString() {
        return "GProForumBody{forumChannel=" + this.forumChannel + ",updateTime=" + this.updateTime + ",everyHours=" + this.everyHours + ",requestId=" + this.requestId + ",}";
    }

    public GProForumBody(ArrayList<GProForumChannel> arrayList, long j2, int i2, String str) {
        this.forumChannel = new ArrayList<>();
        this.requestId = "";
        this.forumChannel = arrayList;
        this.updateTime = j2;
        this.everyHours = i2;
        this.requestId = str;
    }
}
