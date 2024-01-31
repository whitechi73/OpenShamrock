package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProComment {
    long commentCnt;
    long msgSeq;
    long parentSeq;
    long referSeq;
    long rootSeq;

    public GProComment() {
    }

    public long getCommentCnt() {
        return this.commentCnt;
    }

    public long getMsgSeq() {
        return this.msgSeq;
    }

    public long getParentSeq() {
        return this.parentSeq;
    }

    public long getReferSeq() {
        return this.referSeq;
    }

    public long getRootSeq() {
        return this.rootSeq;
    }

    public String toString() {
        return "GProComment{msgSeq=" + this.msgSeq + ",rootSeq=" + this.rootSeq + ",parentSeq=" + this.parentSeq + ",referSeq=" + this.referSeq + ",commentCnt=" + this.commentCnt + ",}";
    }

    public GProComment(long j2, long j3, long j4, long j5, long j6) {
        this.msgSeq = j2;
        this.rootSeq = j3;
        this.parentSeq = j4;
        this.referSeq = j5;
        this.commentCnt = j6;
    }
}
