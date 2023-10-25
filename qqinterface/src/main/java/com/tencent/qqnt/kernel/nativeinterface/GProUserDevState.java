package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProUserDevState implements Serializable {
    int cameraState;
    String currentRoomId;
    int micState;
    int networkQuality;
    int screenState;
    long serialVersionUID;
    int sysMicBusy;

    public GProUserDevState() {
        this.serialVersionUID = 1L;
        this.currentRoomId = "";
    }

    public int getCameraState() {
        return this.cameraState;
    }

    public String getCurrentRoomId() {
        return this.currentRoomId;
    }

    public int getMicState() {
        return this.micState;
    }

    public int getNetworkQuality() {
        return this.networkQuality;
    }

    public int getScreenState() {
        return this.screenState;
    }

    public int getSysMicBusy() {
        return this.sysMicBusy;
    }

    public void setCameraState(int i2) {
        this.cameraState = i2;
    }

    public void setCurrentRoomId(String str) {
        this.currentRoomId = str;
    }

    public void setMicState(int i2) {
        this.micState = i2;
    }

    public void setNetworkQuality(int i2) {
        this.networkQuality = i2;
    }

    public void setScreenState(int i2) {
        this.screenState = i2;
    }

    public void setSysMicBusy(int i2) {
        this.sysMicBusy = i2;
    }

    public String toString() {
        return "GProUserDevState{micState=" + this.micState + ",cameraState=" + this.cameraState + ",screenState=" + this.screenState + ",networkQuality=" + this.networkQuality + ",sysMicBusy=" + this.sysMicBusy + ",currentRoomId=" + this.currentRoomId + ",}";
    }

    public GProUserDevState(int i2, int i3, int i4, int i5, int i6, String str) {
        this.serialVersionUID = 1L;
        this.currentRoomId = "";
        this.micState = i2;
        this.cameraState = i3;
        this.screenState = i4;
        this.networkQuality = i5;
        this.sysMicBusy = i6;
        this.currentRoomId = str;
    }
}
