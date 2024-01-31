package com.tencent.qqnt.kernel.nativeinterface;

public  final class NumericPointInfo {
    long num;
    long readSeqNo;
    long seqNo;

    public NumericPointInfo() {
    }

    public long getNum() {
        return this.num;
    }

    public long getReadSeqNo() {
        return this.readSeqNo;
    }

    public long getSeqNo() {
        return this.seqNo;
    }

    public String toString() {
        return "NumericPointInfo{num=" + this.num + ",seqNo=" + this.seqNo + ",readSeqNo=" + this.readSeqNo + ",}";
    }

    public NumericPointInfo(long j2, long j3, long j4) {
        this.num = j2;
        this.seqNo = j3;
        this.readSeqNo = j4;
    }
}
