package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;


public  final class CommentForRead {
    String content;
    long createTime;
    String id;
    Like likeInfo;
    User postUser;
    Integer replyCount;
    RichText richContents;
    long sequence;
    ArrayList<Reply> vecReply;

    public CommentForRead() {
        this.id = "";
        this.postUser = new User();
        this.content = "";
    }

    public String getContent() {
        return this.content;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public String getId() {
        return this.id;
    }

    public Like getLikeInfo() {
        return this.likeInfo;
    }

    public User getPostUser() {
        return this.postUser;
    }

    public Integer getReplyCount() {
        return this.replyCount;
    }

    public RichText getRichContents() {
        return this.richContents;
    }

    public long getSequence() {
        return this.sequence;
    }

    public ArrayList<Reply> getVecReply() {
        return this.vecReply;
    }

    public String toString() {
        return "CommentForRead{id=" + this.id + ",postUser=" + this.postUser + ",createTime=" + this.createTime + ",content=" + this.content + ",replyCount=" + this.replyCount + ",vecReply=" + this.vecReply + ",likeInfo=" + this.likeInfo + ",richContents=" + this.richContents + ",sequence=" + this.sequence + ",}";
    }

    public CommentForRead(String str, User user, long j2, String str2, Integer num, ArrayList<Reply> arrayList, Like like, RichText richText, long j3) {
        this.id = "";
        this.postUser = new User();
        this.content = "";
        this.id = str;
        this.postUser = user;
        this.createTime = j2;
        this.content = str2;
        this.replyCount = num;
        this.vecReply = arrayList;
        this.likeInfo = like;
        this.richContents = richText;
        this.sequence = j3;
    }
}
