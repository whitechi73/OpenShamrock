package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProGuildChannelState {
    String desc;
    int state;

    public GProGuildChannelState() {
        this.desc = "";
    }

    public String getDesc() {
        return this.desc;
    }

    public int getState() {
        return this.state;
    }

    public String toString() {
        return "GProGuildChannelState{state=" + this.state + ",desc=" + this.desc + ",}";
    }

    public GProGuildChannelState(int i2, String str) {
        this.desc = "";
        this.state = i2;
        this.desc = str;
    }
}
