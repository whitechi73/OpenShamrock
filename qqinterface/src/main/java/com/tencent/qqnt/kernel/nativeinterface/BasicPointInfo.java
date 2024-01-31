package com.tencent.qqnt.kernel.nativeinterface;

public  final class BasicPointInfo {
    byte[] headUrl;
    long readSeqNo;
    long seqNo;

    public BasicPointInfo() {
        this.headUrl = new byte[0];
    }

    public byte[] getHeadUrl() {
        return this.headUrl;
    }

    public long getReadSeqNo() {
        return this.readSeqNo;
    }

    public long getSeqNo() {
        return this.seqNo;
    }

    public String toString() {
        return "BasicPointInfo{headUrl=" + this.headUrl + ",seqNo=" + this.seqNo + ",readSeqNo=" + this.readSeqNo + ",}";
    }

    public BasicPointInfo(byte[] bArr, long j2, long j3) {
        this.headUrl = new byte[0];
        this.headUrl = bArr;
        this.seqNo = j2;
        this.readSeqNo = j3;
    }
}
