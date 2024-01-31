package com.tencent.qqnt.kernel.nativeinterface;

public  final class GProFDLStLike {
    String likeId;

    public GProFDLStLike() {
        this.likeId = "";
    }

    public String getLikeId() {
        return this.likeId;
    }

    public String toString() {
        return "GProFDLStLike{likeId=" + this.likeId + ",}";
    }

    public GProFDLStLike(String str) {
        this.likeId = "";
        this.likeId = str;
    }
}
