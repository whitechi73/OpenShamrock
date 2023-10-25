package com.tencent.qqnt.kernel.nativeinterface;

public final class AnonyStatus {
    int forbidTalking;
    String statusInfo;

    public AnonyStatus() {
        this.statusInfo = "";
    }

    public int getForbidTalking() {
        return this.forbidTalking;
    }

    public String getStatusInfo() {
        return this.statusInfo;
    }

    public String toString() {
        return "AnonyStatus{forbidTalking=" + this.forbidTalking + ",statusInfo=" + this.statusInfo + ",}";
    }

    public AnonyStatus(int i2, String str) {
        this.statusInfo = "";
        this.forbidTalking = i2;
        this.statusInfo = str;
    }
}
