package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProRecommendEssenceSvrRsp {
    String content;
    ArrayList<GProRecommendChannel0x11bc> recommendChannels;

    public GProRecommendEssenceSvrRsp() {
        this.content = "";
        this.recommendChannels = new ArrayList<>();
    }

    public String getContent() {
        return this.content;
    }

    public ArrayList<GProRecommendChannel0x11bc> getRecommendChannels() {
        return this.recommendChannels;
    }

    public String toString() {
        return "GProRecommendEssenceSvrRsp{content=" + this.content + ",recommendChannels=" + this.recommendChannels + ",}";
    }

    public GProRecommendEssenceSvrRsp(String str, ArrayList<GProRecommendChannel0x11bc> arrayList) {
        this.content = "";
        this.recommendChannels = new ArrayList<>();
        this.content = str;
        this.recommendChannels = arrayList;
    }
}
