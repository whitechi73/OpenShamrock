package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProSlowModeInfo implements Serializable {
    long serialVersionUID;
    int slowModeCircle;
    int slowModeKey;
    String slowModeText;
    int speakFrequency;

    public GProSlowModeInfo() {
        this.serialVersionUID = 1L;
        this.slowModeText = "";
    }

    public int getSlowModeCircle() {
        return this.slowModeCircle;
    }

    public int getSlowModeKey() {
        return this.slowModeKey;
    }

    public String getSlowModeText() {
        return this.slowModeText;
    }

    public int getSpeakFrequency() {
        return this.speakFrequency;
    }

    public String toString() {
        return "GProSlowModeInfo{slowModeKey=" + this.slowModeKey + ",speakFrequency=" + this.speakFrequency + ",slowModeCircle=" + this.slowModeCircle + ",slowModeText=" + this.slowModeText + ",}";
    }

    public GProSlowModeInfo(int i2, int i3, int i4, String str) {
        this.serialVersionUID = 1L;
        this.slowModeText = "";
        this.slowModeKey = i2;
        this.speakFrequency = i3;
        this.slowModeCircle = i4;
        this.slowModeText = str;
    }
}
