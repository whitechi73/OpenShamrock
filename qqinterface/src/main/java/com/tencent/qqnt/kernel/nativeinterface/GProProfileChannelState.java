package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProProfileChannelState {
    String channelName;
    String pvNumStr;

    public GProProfileChannelState() {
        this.channelName = "";
        this.pvNumStr = "";
    }

    public String getChannelName() {
        return this.channelName;
    }

    public String getPvNumStr() {
        return this.pvNumStr;
    }

    public String toString() {
        return "GProProfileChannelState{channelName=" + this.channelName + ",pvNumStr=" + this.pvNumStr + ",}";
    }

    public GProProfileChannelState(String str, String str2) {
        this.channelName = "";
        this.pvNumStr = "";
        this.channelName = str;
        this.pvNumStr = str2;
    }
}
