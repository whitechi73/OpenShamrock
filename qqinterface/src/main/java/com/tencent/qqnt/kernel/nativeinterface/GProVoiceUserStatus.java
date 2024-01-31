package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProVoiceUserStatus {
    int networkQuality;
    int screenShareMicStatus;
    int sysMicStatus;
    long tinyId;

    public GProVoiceUserStatus() {
    }

    public int getNetworkQuality() {
        return this.networkQuality;
    }

    public int getScreenShareMicStatus() {
        return this.screenShareMicStatus;
    }

    public int getSysMicStatus() {
        return this.sysMicStatus;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public String toString() {
        return "GProVoiceUserStatus{tinyId=" + this.tinyId + ",networkQuality=" + this.networkQuality + ",sysMicStatus=" + this.sysMicStatus + ",screenShareMicStatus=" + this.screenShareMicStatus + ",}";
    }

    public GProVoiceUserStatus(long j2, int i2, int i3, int i4) {
        this.tinyId = j2;
        this.networkQuality = i2;
        this.sysMicStatus = i3;
        this.screenShareMicStatus = i4;
    }
}
