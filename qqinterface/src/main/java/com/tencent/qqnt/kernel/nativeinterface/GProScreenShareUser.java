package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProScreenShareUser {
    int state;
    long tinyId;

    public GProScreenShareUser() {
    }

    public int getState() {
        return this.state;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public String toString() {
        return "GProScreenShareUser{tinyId=" + this.tinyId + ",state=" + this.state + ",}";
    }

    public GProScreenShareUser(long j2, int i2) {
        this.tinyId = j2;
        this.state = i2;
    }
}
