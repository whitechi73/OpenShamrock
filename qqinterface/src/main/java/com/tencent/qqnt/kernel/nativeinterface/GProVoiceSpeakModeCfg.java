package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProVoiceSpeakModeCfg implements Serializable {
    long serialVersionUID = 1;
    int speakMode;
    int speakSecond;

    public GProVoiceSpeakModeCfg() {
    }

    public int getSpeakMode() {
        return this.speakMode;
    }

    public int getSpeakSecond() {
        return this.speakSecond;
    }

    public String toString() {
        return "GProVoiceSpeakModeCfg{speakMode=" + this.speakMode + ",speakSecond=" + this.speakSecond + ",}";
    }

    public GProVoiceSpeakModeCfg(int i2, int i3) {
        this.speakMode = i2;
        this.speakSecond = i3;
    }
}
