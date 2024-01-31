package com.tencent.qqnt.kernel.nativeinterface;


public  final class CommentFeedReq {
    RichText commentContent;
    CommentLabel commentLabel;
    int commentType;
    FeedForComment feed;
    String jsonComment;
    int tableType;

    public CommentFeedReq() {
        this.commentLabel = new CommentLabel();
        this.feed = new FeedForComment();
        this.commentContent = new RichText();
        this.jsonComment = "";
    }

    public RichText getCommentContent() {
        return this.commentContent;
    }

    public CommentLabel getCommentLabel() {
        return this.commentLabel;
    }

    public int getCommentType() {
        return this.commentType;
    }

    public FeedForComment getFeed() {
        return this.feed;
    }

    public String getJsonComment() {
        return this.jsonComment;
    }

    public int getTableType() {
        return this.tableType;
    }

    public String toString() {
        return "CommentFeedReq{tableType=" + this.tableType + ",commentType=" + this.commentType + ",commentLabel=" + this.commentLabel + ",feed=" + this.feed + ",commentContent=" + this.commentContent + ",jsonComment=" + this.jsonComment + ",}";
    }

    public CommentFeedReq(int i2, int i3, CommentLabel commentLabel, FeedForComment feedForComment, RichText richText, String str) {
        this.commentLabel = new CommentLabel();
        this.feed = new FeedForComment();
        this.commentContent = new RichText();
        this.jsonComment = "";
        this.tableType = i2;
        this.commentType = i3;
        this.commentLabel = commentLabel;
        this.feed = feedForComment;
        this.commentContent = richText;
        this.jsonComment = str;
    }
}
