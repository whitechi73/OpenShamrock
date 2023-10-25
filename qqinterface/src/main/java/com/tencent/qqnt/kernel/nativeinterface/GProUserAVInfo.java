package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProUserAVInfo implements Serializable {
    long serialVersionUID;
    GProSpeakTimeCtl speakTimeCtl;
    int userAVState;
    GProUserDevState userDevState;
    boolean userInSpeakQueue;
    boolean userIsHandUp;

    public GProUserAVInfo() {
        this.serialVersionUID = 1L;
        this.userDevState = new GProUserDevState();
        this.speakTimeCtl = new GProSpeakTimeCtl();
    }

    public GProSpeakTimeCtl getSpeakTimeCtl() {
        return this.speakTimeCtl;
    }

    public int getUserAVState() {
        return this.userAVState;
    }

    public GProUserDevState getUserDevState() {
        return this.userDevState;
    }

    public boolean getUserInSpeakQueue() {
        return this.userInSpeakQueue;
    }

    public boolean getUserIsHandUp() {
        return this.userIsHandUp;
    }

    public void setSpeakTimeCtl(GProSpeakTimeCtl gProSpeakTimeCtl) {
        this.speakTimeCtl = gProSpeakTimeCtl;
    }

    public void setUserAVState(int i2) {
        this.userAVState = i2;
    }

    public void setUserDevState(GProUserDevState gProUserDevState) {
        this.userDevState = gProUserDevState;
    }

    public void setUserInSpeakQueue(boolean z) {
        this.userInSpeakQueue = z;
    }

    public void setUserIsHandUp(boolean z) {
        this.userIsHandUp = z;
    }

    public String toString() {
        return "GProUserAVInfo{userAVState=" + this.userAVState + ",userDevState=" + this.userDevState + ",userIsHandUp=" + this.userIsHandUp + ",userInSpeakQueue=" + this.userInSpeakQueue + ",speakTimeCtl=" + this.speakTimeCtl + ",}";
    }

    public GProUserAVInfo(int i2, GProUserDevState gProUserDevState, boolean z, boolean z2, GProSpeakTimeCtl gProSpeakTimeCtl) {
        this.serialVersionUID = 1L;
        this.userDevState = new GProUserDevState();
        this.speakTimeCtl = new GProSpeakTimeCtl();
        this.userAVState = i2;
        this.userDevState = gProUserDevState;
        this.userIsHandUp = z;
        this.userInSpeakQueue = z2;
        this.speakTimeCtl = gProSpeakTimeCtl;
    }
}
