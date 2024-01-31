package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public  final class GProVoiceInfo implements Serializable {
    String screenPic;
    long screenShareTinyId;
    int screenState;
    long screenUpdateTime;
    long serialVersionUID;
    int voiceState;

    public GProVoiceInfo() {
        this.serialVersionUID = 1L;
        this.screenPic = "";
    }

    public String getScreenPic() {
        return this.screenPic;
    }

    public long getScreenShareTinyId() {
        return this.screenShareTinyId;
    }

    public int getScreenState() {
        return this.screenState;
    }

    public long getScreenUpdateTime() {
        return this.screenUpdateTime;
    }

    public int getVoiceState() {
        return this.voiceState;
    }

    public String toString() {
        return "GProVoiceInfo{voiceState=" + this.voiceState + ",screenState=" + this.screenState + ",screenPic=" + this.screenPic + ",screenUpdateTime=" + this.screenUpdateTime + ",screenShareTinyId=" + this.screenShareTinyId + ",}";
    }

    public GProVoiceInfo(int i2, int i3, String str, long j2, long j3) {
        this.serialVersionUID = 1L;
        this.screenPic = "";
        this.voiceState = i2;
        this.screenState = i3;
        this.screenPic = str;
        this.screenUpdateTime = j2;
        this.screenShareTinyId = j3;
    }
}
