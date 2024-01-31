package com.tencent.qqnt.kernel.nativeinterface;


public  final class ReplyLabel {
    Long createTime;
    String id;
    String likeId;
    UserForComment postUser;

    public ReplyLabel() {
        this.id = "";
        this.postUser = new UserForComment();
    }

    public Long getCreateTime() {
        return this.createTime;
    }

    public String getId() {
        return this.id;
    }

    public String getLikeId() {
        return this.likeId;
    }

    public UserForComment getPostUser() {
        return this.postUser;
    }

    public String toString() {
        return "ReplyLabel{id=" + this.id + ",postUser=" + this.postUser + ",likeId=" + this.likeId + ",createTime=" + this.createTime + ",}";
    }

    public ReplyLabel(String str, UserForComment userForComment, String str2, Long l2) {
        this.id = "";
        this.postUser = new UserForComment();
        this.id = str;
        this.postUser = userForComment;
        this.likeId = str2;
        this.createTime = l2;
    }
}
