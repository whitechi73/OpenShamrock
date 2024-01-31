package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProSearchDataFilter {
    boolean channelManager;

    public GProSearchDataFilter() {
    }

    public boolean getChannelManager() {
        return this.channelManager;
    }

    public String toString() {
        return "GProSearchDataFilter{channelManager=" + this.channelManager + ",}";
    }

    public GProSearchDataFilter(boolean z) {
        this.channelManager = z;
    }
}
