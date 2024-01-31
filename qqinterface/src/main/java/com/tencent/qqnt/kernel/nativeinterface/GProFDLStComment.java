package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProFDLStComment {
    String commentId;
    GProFDLStLike like;

    public GProFDLStComment() {
        this.commentId = "";
        this.like = new GProFDLStLike();
    }

    public String getCommentId() {
        return this.commentId;
    }

    public GProFDLStLike getLike() {
        return this.like;
    }

    public String toString() {
        return "GProFDLStComment{commentId=" + this.commentId + ",like=" + this.like + ",}";
    }

    public GProFDLStComment(String str, GProFDLStLike gProFDLStLike) {
        this.commentId = "";
        this.like = new GProFDLStLike();
        this.commentId = str;
        this.like = gProFDLStLike;
    }
}
