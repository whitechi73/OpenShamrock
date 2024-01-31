package com.tencent.qqnt.kernel.nativeinterface;


public  final class ReplyFeedReq {
    CommentForRead comment;
    int commentType;
    Feed feed;
    String jsonReply;
    Reply reply;

    public ReplyFeedReq() {
        this.reply = new Reply();
        this.comment = new CommentForRead();
        this.feed = new Feed();
        this.jsonReply = "";
    }

    public CommentForRead getComment() {
        return this.comment;
    }

    public int getCommentType() {
        return this.commentType;
    }

    public Feed getFeed() {
        return this.feed;
    }

    public String getJsonReply() {
        return this.jsonReply;
    }

    public Reply getReply() {
        return this.reply;
    }

    public String toString() {
        return "ReplyFeedReq{commentType=" + this.commentType + ",reply=" + this.reply + ",comment=" + this.comment + ",feed=" + this.feed + ",jsonReply=" + this.jsonReply + ",}";
    }

    public ReplyFeedReq(int i2, Reply reply, CommentForRead commentForRead, Feed feed, String str) {
        this.reply = new Reply();
        this.comment = new CommentForRead();
        this.feed = new Feed();
        this.jsonReply = "";
        this.commentType = i2;
        this.reply = reply;
        this.comment = commentForRead;
        this.feed = feed;
        this.jsonReply = str;
    }
}
