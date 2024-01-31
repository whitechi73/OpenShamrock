package com.tencent.qqnt.kernel.nativeinterface;



public final class TotalLike {
    boolean isClicked;
    int likeCount;

    public TotalLike() {
    }

    public boolean getIsClicked() {
        return this.isClicked;
    }

    public int getLikeCount() {
        return this.likeCount;
    }

    public String toString() {
        return "TotalLike{likeCount=" + this.likeCount + ",isClicked=" + this.isClicked + ",}";
    }

    public TotalLike(int i2, boolean z) {
        this.likeCount = i2;
        this.isClicked = z;
    }
}
