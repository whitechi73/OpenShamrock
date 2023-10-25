package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes4.dex */
public final class GProDoLikeForFeedRsp {
    GProFDLStCommonExt extInfo;
    GProFDLStLike like;

    public GProDoLikeForFeedRsp() {
        this.extInfo = new GProFDLStCommonExt();
        this.like = new GProFDLStLike();
    }

    public GProFDLStCommonExt getExtInfo() {
        return this.extInfo;
    }

    public GProFDLStLike getLike() {
        return this.like;
    }

    public String toString() {
        return "GProDoLikeForFeedRsp{extInfo=" + this.extInfo + ",like=" + this.like + ",}";
    }

    public GProDoLikeForFeedRsp(GProFDLStCommonExt gProFDLStCommonExt, GProFDLStLike gProFDLStLike) {
        this.extInfo = new GProFDLStCommonExt();
        this.like = new GProFDLStLike();
        this.extInfo = gProFDLStCommonExt;
        this.like = gProFDLStLike;
    }
}
