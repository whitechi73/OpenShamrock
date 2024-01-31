package com.tencent.qqnt.kernel.nativeinterface;


public  final class FeedForComment {
    long createTime;
    String id;
    String posterId;

    public FeedForComment() {
        this.id = "";
        this.posterId = "";
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public String getId() {
        return this.id;
    }

    public String getPosterId() {
        return this.posterId;
    }

    public String toString() {
        return "FeedForComment{id=" + this.id + ",posterId=" + this.posterId + ",createTime=" + this.createTime + ",}";
    }

    public FeedForComment(String str, String str2, long j2) {
        this.id = "";
        this.posterId = "";
        this.id = str;
        this.posterId = str2;
        this.createTime = j2;
    }
}
