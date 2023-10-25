package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProSourceId {
    int entranceId;
    String flagId;
    String openId;
    String sceneId;
    long sourceApp;
    String sourceId;
    int sourceType;
    String subSourceId;

    public GProSourceId() {
        this.sourceId = "";
        this.subSourceId = "";
        this.sceneId = "";
        this.openId = "";
        this.flagId = "";
    }

    public int getEntranceId() {
        return this.entranceId;
    }

    public String getFlagId() {
        return this.flagId;
    }

    public String getOpenId() {
        return this.openId;
    }

    public String getSceneId() {
        return this.sceneId;
    }

    public long getSourceApp() {
        return this.sourceApp;
    }

    public String getSourceId() {
        return this.sourceId;
    }

    public int getSourceType() {
        return this.sourceType;
    }

    public String getSubSourceId() {
        return this.subSourceId;
    }

    public String toString() {
        return "GProSourceId{sourceId=" + this.sourceId + ",subSourceId=" + this.subSourceId + ",entranceId=" + this.entranceId + ",sourceType=" + this.sourceType + ",sourceApp=" + this.sourceApp + ",sceneId=" + this.sceneId + ",openId=" + this.openId + ",flagId=" + this.flagId + ",}";
    }

    public GProSourceId(String str, String str2, int i2, int i3, long j2, String str3, String str4, String str5) {
        this.sourceId = "";
        this.subSourceId = "";
        this.sceneId = "";
        this.openId = "";
        this.flagId = "";
        this.sourceId = str;
        this.subSourceId = str2;
        this.entranceId = i2;
        this.sourceType = i3;
        this.sourceApp = j2;
        this.sceneId = str3;
        this.openId = str4;
        this.flagId = str5;
    }
}
