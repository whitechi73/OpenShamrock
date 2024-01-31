package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public  final class GProRecommendSeqInfo implements Serializable {
    byte[] maxBytesReadMsgMeta;
    long maxCntSeq;
    long maxMsgSeq;
    long serialVersionUID;

    public GProRecommendSeqInfo() {
        this.serialVersionUID = 1L;
        this.maxBytesReadMsgMeta = new byte[0];
    }

    public byte[] getMaxBytesReadMsgMeta() {
        return this.maxBytesReadMsgMeta;
    }

    public long getMaxCntSeq() {
        return this.maxCntSeq;
    }

    public long getMaxMsgSeq() {
        return this.maxMsgSeq;
    }

    public String toString() {
        return "GProRecommendSeqInfo{maxMsgSeq=" + this.maxMsgSeq + ",maxCntSeq=" + this.maxCntSeq + ",maxBytesReadMsgMeta=" + this.maxBytesReadMsgMeta + ",}";
    }

    public GProRecommendSeqInfo(long j2, long j3, byte[] bArr) {
        this.serialVersionUID = 1L;
        this.maxBytesReadMsgMeta = new byte[0];
        this.maxMsgSeq = j2;
        this.maxCntSeq = j3;
        this.maxBytesReadMsgMeta = bArr;
    }
}
