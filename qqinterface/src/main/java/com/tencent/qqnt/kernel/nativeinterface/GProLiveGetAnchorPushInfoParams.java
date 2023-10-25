package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes2.dex */
public final class GProLiveGetAnchorPushInfoParams {
    Long anchorId;
    Long roomId;

    public GProLiveGetAnchorPushInfoParams() {
    }

    public Long getAnchorId() {
        return this.anchorId;
    }

    public Long getRoomId() {
        return this.roomId;
    }

    public String toString() {
        return "GProLiveGetAnchorPushInfoParams{roomId=" + this.roomId + ",anchorId=" + this.anchorId + ",}";
    }

    public GProLiveGetAnchorPushInfoParams(Long l2, Long l3) {
        this.roomId = l2;
        this.anchorId = l3;
    }
}
