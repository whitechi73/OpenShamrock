package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProPlayNodeExtInfo implements Serializable {
    long compereTinyid;
    boolean enableVolume;
    int pauseDuration;
    int playState;
    GProPlayPushScene pushScene;
    long serialVersionUID;
    long sourceNum;
    long startPlayTime;
    int volume;

    public GProPlayNodeExtInfo() {
        this.serialVersionUID = 1L;
        this.pushScene = new GProPlayPushScene();
    }

    public long getCompereTinyid() {
        return this.compereTinyid;
    }

    public boolean getEnableVolume() {
        return this.enableVolume;
    }

    public int getPauseDuration() {
        return this.pauseDuration;
    }

    public int getPlayState() {
        return this.playState;
    }

    public GProPlayPushScene getPushScene() {
        return this.pushScene;
    }

    public long getSourceNum() {
        return this.sourceNum;
    }

    public long getStartPlayTime() {
        return this.startPlayTime;
    }

    public int getVolume() {
        return this.volume;
    }

    public String toString() {
        return "GProPlayNodeExtInfo{playState=" + this.playState + ",startPlayTime=" + this.startPlayTime + ",pauseDuration=" + this.pauseDuration + ",sourceNum=" + this.sourceNum + ",compereTinyid=" + this.compereTinyid + ",enableVolume=" + this.enableVolume + ",volume=" + this.volume + ",pushScene=" + this.pushScene + ",}";
    }

    public GProPlayNodeExtInfo(int i2, long j2, int i3, long j3, long j4, boolean z, int i4, GProPlayPushScene gProPlayPushScene) {
        this.serialVersionUID = 1L;
        this.pushScene = new GProPlayPushScene();
        this.playState = i2;
        this.startPlayTime = j2;
        this.pauseDuration = i3;
        this.sourceNum = j3;
        this.compereTinyid = j4;
        this.enableVolume = z;
        this.volume = i4;
        this.pushScene = gProPlayPushScene;
    }
}
