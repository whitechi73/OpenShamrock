package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProMsgSeq {
    long uint64Seq;
    long uint64Time;

    public GProMsgSeq() {
    }

    public long getUint64Seq() {
        return this.uint64Seq;
    }

    public long getUint64Time() {
        return this.uint64Time;
    }

    public String toString() {
        return "GProMsgSeq{uint64Seq=" + this.uint64Seq + ",uint64Time=" + this.uint64Time + ",}";
    }

    public GProMsgSeq(long j2, long j3) {
        this.uint64Seq = j2;
        this.uint64Time = j3;
    }
}
