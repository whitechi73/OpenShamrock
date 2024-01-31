package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProFDLStLike;

public  class GGProFDLStLike implements IGProFDLStLike {
    public final GProFDLStLike mInfo;

    public GGProFDLStLike(GProFDLStLike gProFDLStLike) {
        this.mInfo = gProFDLStLike;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProFDLStLike
    public String getLikeId() {
        return this.mInfo.getLikeId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProFDLStLike
    public String toString() {
        return this.mInfo.toString();
    }
}
