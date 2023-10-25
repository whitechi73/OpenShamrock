package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes4.dex */
public final class GProDoLikeForFeedReq {
    GProFDLStComment comment;
    GProFDLStCommonExt extInfo;
    GProFDLStFeed feed;
    GProFDLStLike like;
    int likeType;

    public GProDoLikeForFeedReq() {
        this.extInfo = new GProFDLStCommonExt();
        this.like = new GProFDLStLike();
        this.feed = new GProFDLStFeed();
        this.comment = new GProFDLStComment();
    }

    public GProFDLStComment getComment() {
        return this.comment;
    }

    public GProFDLStCommonExt getExtInfo() {
        return this.extInfo;
    }

    public GProFDLStFeed getFeed() {
        return this.feed;
    }

    public GProFDLStLike getLike() {
        return this.like;
    }

    public int getLikeType() {
        return this.likeType;
    }

    public String toString() {
        return "GProDoLikeForFeedReq{extInfo=" + this.extInfo + ",likeType=" + this.likeType + ",like=" + this.like + ",feed=" + this.feed + ",comment=" + this.comment + ",}";
    }

    public GProDoLikeForFeedReq(GProFDLStCommonExt gProFDLStCommonExt, int i2, GProFDLStLike gProFDLStLike, GProFDLStFeed gProFDLStFeed, GProFDLStComment gProFDLStComment) {
        this.extInfo = new GProFDLStCommonExt();
        this.like = new GProFDLStLike();
        this.feed = new GProFDLStFeed();
        this.comment = new GProFDLStComment();
        this.extInfo = gProFDLStCommonExt;
        this.likeType = i2;
        this.like = gProFDLStLike;
        this.feed = gProFDLStFeed;
        this.comment = gProFDLStComment;
    }
}
