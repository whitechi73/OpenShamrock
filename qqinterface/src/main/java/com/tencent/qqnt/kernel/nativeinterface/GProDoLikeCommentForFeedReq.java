package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes4.dex */
public final class GProDoLikeCommentForFeedReq {
    String commentId;
    GProFDLStCommonExt extInfo;
    String feedId;
    int likeType;

    public GProDoLikeCommentForFeedReq() {
        this.extInfo = new GProFDLStCommonExt();
        this.commentId = "";
        this.feedId = "";
    }

    public String getCommentId() {
        return this.commentId;
    }

    public GProFDLStCommonExt getExtInfo() {
        return this.extInfo;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public int getLikeType() {
        return this.likeType;
    }

    public String toString() {
        return "GProDoLikeCommentForFeedReq{extInfo=" + this.extInfo + ",likeType=" + this.likeType + ",commentId=" + this.commentId + ",feedId=" + this.feedId + ",}";
    }

    public GProDoLikeCommentForFeedReq(GProFDLStCommonExt gProFDLStCommonExt, int i2, String str, String str2) {
        this.extInfo = new GProFDLStCommonExt();
        this.commentId = "";
        this.feedId = "";
        this.extInfo = gProFDLStCommonExt;
        this.likeType = i2;
        this.commentId = str;
        this.feedId = str2;
    }
}
