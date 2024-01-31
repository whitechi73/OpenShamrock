package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;


public class GProScreenShareUserData implements Serializable {
    private int state;
    private long tinyId;

    public GProScreenShareUserData(long j2, int i2) {
        this.tinyId = j2;
        this.state = i2;
    }

    public int getScreenState() {
        return this.state;
    }

    public long getTinyId() {
        return this.tinyId;
    }
}
