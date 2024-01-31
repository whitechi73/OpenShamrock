package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;


public  final class Reply implements IKernelModel, Serializable {
    String content;
    long createTime;
    String id;
    Like likeInfo;
    User postUser;
    RichText richContents;
    long serialVersionUID;
    User targetUser;
    Integer typeFlag2;

    public Reply() {
        this.serialVersionUID = 1L;
        this.postUser = new User();
        this.targetUser = new User();
        this.richContents = new RichText();
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

    public RichText getRichContents() {
        return this.richContents;
    }

    public User getTargetUser() {
        return this.targetUser;
    }

    public Integer getTypeFlag2() {
        return this.typeFlag2;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setCreateTime(long j2) {
        this.createTime = j2;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setLikeInfo(Like like) {
        this.likeInfo = like;
    }

    public void setPostUser(User user) {
        this.postUser = user;
    }

    public void setRichContents(RichText richText) {
        this.richContents = richText;
    }

    public void setTargetUser(User user) {
        this.targetUser = user;
    }

    public void setTypeFlag2(Integer num) {
        this.typeFlag2 = num;
    }

    public String toString() {
        return "Reply{id=" + this.id + ",postUser=" + this.postUser + ",createTime=" + this.createTime + ",content=" + this.content + ",targetUser=" + this.targetUser + ",likeInfo=" + this.likeInfo + ",typeFlag2=" + this.typeFlag2 + ",richContents=" + this.richContents + ",}";
    }

    public Reply(String str, User user, long j2, String str2, User user2, Like like, Integer num, RichText richText) {
        this.serialVersionUID = 1L;
        this.postUser = new User();
        this.targetUser = new User();
        this.richContents = new RichText();
        this.id = str;
        this.postUser = user;
        this.createTime = j2;
        this.content = str2;
        this.targetUser = user2;
        this.likeInfo = like;
        this.typeFlag2 = num;
        this.richContents = richText;
    }
}
