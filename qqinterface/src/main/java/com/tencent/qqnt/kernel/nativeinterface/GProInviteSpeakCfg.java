package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes4.dex */
public final class GProInviteSpeakCfg implements Serializable {
    int inviteSpeakState;
    long serialVersionUID = 1;

    public GProInviteSpeakCfg() {
    }

    public int getInviteSpeakState() {
        return this.inviteSpeakState;
    }

    public String toString() {
        return "GProInviteSpeakCfg{inviteSpeakState=" + this.inviteSpeakState + ",}";
    }

    public GProInviteSpeakCfg(int i2) {
        this.inviteSpeakState = i2;
    }
}
