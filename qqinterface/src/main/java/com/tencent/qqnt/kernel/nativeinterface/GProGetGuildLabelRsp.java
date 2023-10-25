package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProGetGuildLabelRsp {
    ArrayList<GProLabelInfo> labelInfos;
    long maxAvNums;
    long maxLabels;
    String welcomeContent;

    public GProGetGuildLabelRsp() {
        this.welcomeContent = "";
        this.labelInfos = new ArrayList<>();
    }

    public ArrayList<GProLabelInfo> getLabelInfos() {
        return this.labelInfos;
    }

    public long getMaxAvNums() {
        return this.maxAvNums;
    }

    public long getMaxLabels() {
        return this.maxLabels;
    }

    public String getWelcomeContent() {
        return this.welcomeContent;
    }

    public String toString() {
        return "GProGetGuildLabelRsp{maxLabels=" + this.maxLabels + ",maxAvNums=" + this.maxAvNums + ",welcomeContent=" + this.welcomeContent + ",labelInfos=" + this.labelInfos + ",}";
    }

    public GProGetGuildLabelRsp(long j2, long j3, String str, ArrayList<GProLabelInfo> arrayList) {
        this.welcomeContent = "";
        this.labelInfos = new ArrayList<>();
        this.maxLabels = j2;
        this.maxAvNums = j3;
        this.welcomeContent = str;
        this.labelInfos = arrayList;
    }
}
