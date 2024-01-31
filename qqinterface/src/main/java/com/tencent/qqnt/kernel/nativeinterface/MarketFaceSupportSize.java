package com.tencent.qqnt.kernel.nativeinterface;


public  final class MarketFaceSupportSize {
    int height;
    int width;

    public MarketFaceSupportSize() {
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public String toString() {
        return "MarketFaceSupportSize{width=" + this.width + ",height=" + this.height + ",}";
    }

    public MarketFaceSupportSize(int i2, int i3) {
        this.width = i2;
        this.height = i3;
    }
}
