package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProMyChannelInfo {
    boolean boolHasAtMeMsg;
    byte[] bytesReadMsgMeta;
    GProMsgSeq msgReadCntMsgSeq;
    GProMsgSeq msgReadMsgSeq;
    long uint64ChannelId;
    long uint64GuildId;

    public GProMyChannelInfo() {
        this.msgReadMsgSeq = new GProMsgSeq();
        this.msgReadCntMsgSeq = new GProMsgSeq();
        this.bytesReadMsgMeta = new byte[0];
    }

    public boolean getBoolHasAtMeMsg() {
        return this.boolHasAtMeMsg;
    }

    public byte[] getBytesReadMsgMeta() {
        return this.bytesReadMsgMeta;
    }

    public GProMsgSeq getMsgReadCntMsgSeq() {
        return this.msgReadCntMsgSeq;
    }

    public GProMsgSeq getMsgReadMsgSeq() {
        return this.msgReadMsgSeq;
    }

    public long getUint64ChannelId() {
        return this.uint64ChannelId;
    }

    public long getUint64GuildId() {
        return this.uint64GuildId;
    }

    public String toString() {
        return "GProMyChannelInfo{uint64ChannelId=" + this.uint64ChannelId + ",uint64GuildId=" + this.uint64GuildId + ",msgReadMsgSeq=" + this.msgReadMsgSeq + ",msgReadCntMsgSeq=" + this.msgReadCntMsgSeq + ",bytesReadMsgMeta=" + this.bytesReadMsgMeta + ",boolHasAtMeMsg=" + this.boolHasAtMeMsg + ",}";
    }

    public GProMyChannelInfo(long j2, long j3, GProMsgSeq gProMsgSeq, GProMsgSeq gProMsgSeq2, byte[] bArr, boolean z) {
        this.msgReadMsgSeq = new GProMsgSeq();
        this.msgReadCntMsgSeq = new GProMsgSeq();
        this.bytesReadMsgMeta = new byte[0];
        this.uint64ChannelId = j2;
        this.uint64GuildId = j3;
        this.msgReadMsgSeq = gProMsgSeq;
        this.msgReadCntMsgSeq = gProMsgSeq2;
        this.bytesReadMsgMeta = bArr;
        this.boolHasAtMeMsg = z;
    }
}
