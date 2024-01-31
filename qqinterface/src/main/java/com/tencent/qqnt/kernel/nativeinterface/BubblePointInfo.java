package com.tencent.qqnt.kernel.nativeinterface;

public  final class BubblePointInfo {
    long readSeqNo;
    byte[] schema;
    long seqNo;
    byte[] text;

    public BubblePointInfo() {
        this.text = new byte[0];
        this.schema = new byte[0];
    }

    public long getReadSeqNo() {
        return this.readSeqNo;
    }

    public byte[] getSchema() {
        return this.schema;
    }

    public long getSeqNo() {
        return this.seqNo;
    }

    public byte[] getText() {
        return this.text;
    }

    public String toString() {
        return "BubblePointInfo{seqNo=" + this.seqNo + ",readSeqNo=" + this.readSeqNo + ",text=" + this.text + ",schema=" + this.schema + ",}";
    }

    public BubblePointInfo(long j2, long j3, byte[] bArr, byte[] bArr2) {
        this.text = new byte[0];
        this.schema = new byte[0];
        this.seqNo = j2;
        this.readSeqNo = j3;
        this.text = bArr;
        this.schema = bArr2;
    }
}
