package com.tencent.qqnt.kernel.nativeinterface;

public  final class PicDownParams {
    Integer downSize;
    int downType;

    public PicDownParams() {
    }

    public Integer getDownSize() {
        return this.downSize;
    }

    public int getDownType() {
        return this.downType;
    }

    public String toString() {
        return "PicDownParams{downType=" + this.downType + ",downSize=" + this.downSize + ",}";
    }

    public PicDownParams(int i2, Integer num) {
        this.downType = i2;
        this.downSize = num;
    }
}
