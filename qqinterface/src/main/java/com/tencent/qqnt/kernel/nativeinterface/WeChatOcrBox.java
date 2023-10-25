package com.tencent.qqnt.kernel.nativeinterface;

public final class WeChatOcrBox {
    OCRPoint pt1;
    OCRPoint pt2;
    OCRPoint pt3;
    OCRPoint pt4;

    public WeChatOcrBox() {
        this.pt1 = new OCRPoint();
        this.pt2 = new OCRPoint();
        this.pt3 = new OCRPoint();
        this.pt4 = new OCRPoint();
    }

    public OCRPoint getPt1() {
        return this.pt1;
    }

    public OCRPoint getPt2() {
        return this.pt2;
    }

    public OCRPoint getPt3() {
        return this.pt3;
    }

    public OCRPoint getPt4() {
        return this.pt4;
    }

    public String toString() {
        return "WeChatOcrBox{pt1=" + this.pt1 + ",pt2=" + this.pt2 + ",pt3=" + this.pt3 + ",pt4=" + this.pt4 + ",}";
    }

    public WeChatOcrBox(OCRPoint oCRPoint, OCRPoint oCRPoint2, OCRPoint oCRPoint3, OCRPoint oCRPoint4) {
        this.pt1 = new OCRPoint();
        this.pt2 = new OCRPoint();
        this.pt3 = new OCRPoint();
        this.pt4 = new OCRPoint();
        this.pt1 = oCRPoint;
        this.pt2 = oCRPoint2;
        this.pt3 = oCRPoint3;
        this.pt4 = oCRPoint4;
    }
}
