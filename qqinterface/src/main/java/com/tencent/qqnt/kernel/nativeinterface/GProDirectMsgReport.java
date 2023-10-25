package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProDirectMsgReport {
    long guildId;
    byte[] meta;
    long readCntSeq;
    long readCntTime;
    long readMsgSeq;
    long readMsgTime;

    public GProDirectMsgReport() {
        this.meta = new byte[0];
    }

    public long getGuildId() {
        return this.guildId;
    }

    public byte[] getMeta() {
        return this.meta;
    }

    public long getReadCntSeq() {
        return this.readCntSeq;
    }

    public long getReadCntTime() {
        return this.readCntTime;
    }

    public long getReadMsgSeq() {
        return this.readMsgSeq;
    }

    public long getReadMsgTime() {
        return this.readMsgTime;
    }

    public String toString() {
        return "GProDirectMsgReport{guildId=" + this.guildId + ",readMsgSeq=" + this.readMsgSeq + ",readMsgTime=" + this.readMsgTime + ",readCntSeq=" + this.readCntSeq + ",readCntTime=" + this.readCntTime + ",meta=" + this.meta + ",}";
    }

    public GProDirectMsgReport(long j2, long j3, long j4, long j5, long j6, byte[] bArr) {
        this.meta = new byte[0];
        this.guildId = j2;
        this.readMsgSeq = j3;
        this.readMsgTime = j4;
        this.readCntSeq = j5;
        this.readCntTime = j6;
        this.meta = bArr;
    }
}
