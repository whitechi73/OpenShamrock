package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProEnterChannelPermission {
    boolean allowEnter;
    boolean allowLive;
    String disallowLiveReason;
    String disallowReason;
    int liveType;
    String liveUrl;
    long msgSeq;

    public GProEnterChannelPermission() {
        this.disallowReason = "";
        this.disallowLiveReason = "";
        this.liveUrl = "";
    }

    public boolean getAllowEnter() {
        return this.allowEnter;
    }

    public boolean getAllowLive() {
        return this.allowLive;
    }

    public String getDisallowLiveReason() {
        return this.disallowLiveReason;
    }

    public String getDisallowReason() {
        return this.disallowReason;
    }

    public int getLiveType() {
        return this.liveType;
    }

    public String getLiveUrl() {
        return this.liveUrl;
    }

    public long getMsgSeq() {
        return this.msgSeq;
    }

    public String toString() {
        return "GProEnterChannelPermission{allowEnter=" + this.allowEnter + ",disallowReason=" + this.disallowReason + ",allowLive=" + this.allowLive + ",disallowLiveReason=" + this.disallowLiveReason + ",liveUrl=" + this.liveUrl + ",liveType=" + this.liveType + ",msgSeq=" + this.msgSeq + ",}";
    }

    public GProEnterChannelPermission(boolean z, String str, boolean z2, String str2, String str3, int i2, long j2) {
        this.disallowReason = "";
        this.disallowLiveReason = "";
        this.liveUrl = "";
        this.allowEnter = z;
        this.disallowReason = str;
        this.allowLive = z2;
        this.disallowLiveReason = str2;
        this.liveUrl = str3;
        this.liveType = i2;
        this.msgSeq = j2;
    }
}
