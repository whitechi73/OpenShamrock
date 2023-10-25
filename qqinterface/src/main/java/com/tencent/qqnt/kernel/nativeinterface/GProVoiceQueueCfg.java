package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProVoiceQueueCfg implements Serializable {
    long serialVersionUID = 1;
    int voiceQueueState;

    public GProVoiceQueueCfg() {
    }

    public int getVoiceQueueState() {
        return this.voiceQueueState;
    }

    public String toString() {
        return "GProVoiceQueueCfg{voiceQueueState=" + this.voiceQueueState + ",}";
    }

    public GProVoiceQueueCfg(int i2) {
        this.voiceQueueState = i2;
    }
}
