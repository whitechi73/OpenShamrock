package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProAnchorPrepareReq {
    String machine;
    Integer roomType;

    public GProAnchorPrepareReq() {
    }

    public String getMachine() {
        return this.machine;
    }

    public Integer getRoomType() {
        return this.roomType;
    }

    public String toString() {
        return "GProAnchorPrepareReq{roomType=" + this.roomType + ",machine=" + this.machine + ",}";
    }

    public GProAnchorPrepareReq(Integer num, String str) {
        this.roomType = num;
        this.machine = str;
    }
}
