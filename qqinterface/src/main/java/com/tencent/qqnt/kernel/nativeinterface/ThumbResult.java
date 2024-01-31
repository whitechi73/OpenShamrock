package com.tencent.qqnt.kernel.nativeinterface;



public final class ThumbResult {
    int cropHeight;
    int cropWidth;
    int cropXOffset;
    int cropYOffset;
    int scaleHeight;
    int scaleWidth;

    public ThumbResult() {
    }

    public int getCropHeight() {
        return this.cropHeight;
    }

    public int getCropWidth() {
        return this.cropWidth;
    }

    public int getCropXOffset() {
        return this.cropXOffset;
    }

    public int getCropYOffset() {
        return this.cropYOffset;
    }

    public int getScaleHeight() {
        return this.scaleHeight;
    }

    public int getScaleWidth() {
        return this.scaleWidth;
    }

    public String toString() {
        return "ThumbResult{cropXOffset=" + this.cropXOffset + ",cropYOffset=" + this.cropYOffset + ",cropWidth=" + this.cropWidth + ",cropHeight=" + this.cropHeight + ",scaleWidth=" + this.scaleWidth + ",scaleHeight=" + this.scaleHeight + ",}";
    }

    public ThumbResult(int i2, int i3, int i4, int i5, int i6, int i7) {
        this.cropXOffset = i2;
        this.cropYOffset = i3;
        this.cropWidth = i4;
        this.cropHeight = i5;
        this.scaleWidth = i6;
        this.scaleHeight = i7;
    }
}
