package com.tencent.qqnt.kernel.nativeinterface;

public final class OCRPoint {
    String x;
    String y;

    public OCRPoint() {
        this.x = "";
        this.y = "";
    }

    public String getX() {
        return this.x;
    }

    public String getY() {
        return this.y;
    }

    public String toString() {
        return "OCRPoint{x=" + this.x + ",y=" + this.y + ",}";
    }

    public OCRPoint(String str, String str2) {
        this.x = "";
        this.y = "";
        this.x = str;
        this.y = str2;
    }
}