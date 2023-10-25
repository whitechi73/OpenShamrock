package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

public final class WeChatOCRResultLine {
    ArrayList<WeChatOCRResultChar> charBox;
    OCRPoint pt1;
    OCRPoint pt2;
    OCRPoint pt3;
    OCRPoint pt4;
    String score;
    String text;

    public WeChatOCRResultLine() {
        this.text = "";
        this.pt1 = new OCRPoint();
        this.pt2 = new OCRPoint();
        this.pt3 = new OCRPoint();
        this.pt4 = new OCRPoint();
        this.charBox = new ArrayList<>();
        this.score = "";
    }

    public ArrayList<WeChatOCRResultChar> getCharBox() {
        return this.charBox;
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

    public String getScore() {
        return this.score;
    }

    public String getText() {
        return this.text;
    }

    public String toString() {
        return "WeChatOCRResultLine{text=" + this.text + ",pt1=" + this.pt1 + ",pt2=" + this.pt2 + ",pt3=" + this.pt3 + ",pt4=" + this.pt4 + ",charBox=" + this.charBox + ",score=" + this.score + ",}";
    }

    public WeChatOCRResultLine(String str, OCRPoint oCRPoint, OCRPoint oCRPoint2, OCRPoint oCRPoint3, OCRPoint oCRPoint4, ArrayList<WeChatOCRResultChar> arrayList, String str2) {
        this.text = "";
        this.pt1 = new OCRPoint();
        this.pt2 = new OCRPoint();
        this.pt3 = new OCRPoint();
        this.pt4 = new OCRPoint();
        this.charBox = new ArrayList<>();
        this.score = "";
        this.text = str;
        this.pt1 = oCRPoint;
        this.pt2 = oCRPoint2;
        this.pt3 = oCRPoint3;
        this.pt4 = oCRPoint4;
        this.charBox = arrayList;
        this.score = str2;
    }
}
