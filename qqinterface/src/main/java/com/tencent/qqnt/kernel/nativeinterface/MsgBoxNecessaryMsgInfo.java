package com.tencent.qqnt.kernel.nativeinterface;


public  final class MsgBoxNecessaryMsgInfo {
    String highlightDigest;
    long msgSeq;
    long msgTime;

    public MsgBoxNecessaryMsgInfo() {
        this.highlightDigest = "";
    }

    public String getHighlightDigest() {
        return this.highlightDigest;
    }

    public long getMsgSeq() {
        return this.msgSeq;
    }

    public long getMsgTime() {
        return this.msgTime;
    }

    public String toString() {
        return "MsgBoxNecessaryMsgInfo{msgSeq=" + this.msgSeq + ",msgTime=" + this.msgTime + ",highlightDigest=" + this.highlightDigest + ",}";
    }

    public MsgBoxNecessaryMsgInfo(long j2, long j3, String str) {
        this.highlightDigest = "";
        this.msgSeq = j2;
        this.msgTime = j3;
        this.highlightDigest = str;
    }
}
