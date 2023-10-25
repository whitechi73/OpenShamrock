package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProSpeakTimeCtl implements Serializable {
    int queueSpeakS;
    long serialVersionUID = 1;
    long startSpeakMs;
    long stopSpeakMs;

    public GProSpeakTimeCtl() {
    }

    public int getQueueSpeakS() {
        return this.queueSpeakS;
    }

    public long getStartSpeakMs() {
        return this.startSpeakMs;
    }

    public long getStopSpeakMs() {
        return this.stopSpeakMs;
    }

    public String toString() {
        return "GProSpeakTimeCtl{startSpeakMs=" + this.startSpeakMs + ",stopSpeakMs=" + this.stopSpeakMs + ",queueSpeakS=" + this.queueSpeakS + ",}";
    }

    public GProSpeakTimeCtl(long j2, long j3, int i2) {
        this.startSpeakMs = j2;
        this.stopSpeakMs = j3;
        this.queueSpeakS = i2;
    }
}
