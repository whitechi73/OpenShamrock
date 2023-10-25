package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProUserCtlInfo {
    GProAVDevOptInfo devOpt;
    int nextAVState;
    GProSpeakTimeCtl speakTimeCtl;

    public GProUserCtlInfo() {
        this.devOpt = new GProAVDevOptInfo();
        this.speakTimeCtl = new GProSpeakTimeCtl();
    }

    public GProAVDevOptInfo getDevOpt() {
        return this.devOpt;
    }

    public int getNextAVState() {
        return this.nextAVState;
    }

    public GProSpeakTimeCtl getSpeakTimeCtl() {
        return this.speakTimeCtl;
    }

    public String toString() {
        return "GProUserCtlInfo{nextAVState=" + this.nextAVState + ",devOpt=" + this.devOpt + ",speakTimeCtl=" + this.speakTimeCtl + ",}";
    }

    public GProUserCtlInfo(int i2, GProAVDevOptInfo gProAVDevOptInfo, GProSpeakTimeCtl gProSpeakTimeCtl) {
        this.devOpt = new GProAVDevOptInfo();
        this.speakTimeCtl = new GProSpeakTimeCtl();
        this.nextAVState = i2;
        this.devOpt = gProAVDevOptInfo;
        this.speakTimeCtl = gProSpeakTimeCtl;
    }
}
