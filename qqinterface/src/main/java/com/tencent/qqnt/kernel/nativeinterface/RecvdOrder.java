package com.tencent.qqnt.kernel.nativeinterface;


public  final class RecvdOrder {
    long amount;
    int createTime;
    String recvName;
    long recvUin;
    String uid;

    public RecvdOrder() {
        this.recvName = "";
    }

    public long getAmount() {
        return this.amount;
    }

    public int getCreateTime() {
        return this.createTime;
    }

    public String getRecvName() {
        return this.recvName;
    }

    public long getRecvUin() {
        return this.recvUin;
    }

    public String getUid() {
        return this.uid;
    }

    public String toString() {
        return "RecvdOrder{recvUin=" + this.recvUin + ",recvName=" + this.recvName + ",amount=" + this.amount + ",createTime=" + this.createTime + ",uid=" + this.uid + ",}";
    }

    public RecvdOrder(long j2, String str, long j3, int i2, String str2) {
        this.recvName = "";
        this.recvUin = j2;
        this.recvName = str;
        this.amount = j3;
        this.createTime = i2;
        this.uid = str2;
    }
}
