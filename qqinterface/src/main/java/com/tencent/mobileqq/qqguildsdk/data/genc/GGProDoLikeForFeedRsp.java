package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProDoLikeForFeedRsp;

public  class GGProDoLikeForFeedRsp implements IGProDoLikeForFeedRsp {
    public final GProDoLikeForFeedRsp mInfo;

    public GGProDoLikeForFeedRsp(GProDoLikeForFeedRsp gProDoLikeForFeedRsp) {
        this.mInfo = gProDoLikeForFeedRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProDoLikeForFeedRsp
    public IGProFDLStCommonExt getExtInfo() {
        return new GGProFDLStCommonExt(this.mInfo.getExtInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProDoLikeForFeedRsp
    public IGProFDLStLike getLike() {
        return new GGProFDLStLike(this.mInfo.getLike());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProDoLikeForFeedRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
