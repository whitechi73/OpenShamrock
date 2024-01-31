package com.tencent.qqnt.kernel.nativeinterface;


public  final class ReplyAbsFaceElement {
    int faceIndex;
    String faceText;
    int faceType;

    public ReplyAbsFaceElement() {
    }

    public int getFaceIndex() {
        return this.faceIndex;
    }

    public String getFaceText() {
        return this.faceText;
    }

    public int getFaceType() {
        return this.faceType;
    }

    public String toString() {
        return "ReplyAbsFaceElement{faceIndex=" + this.faceIndex + ",faceText=" + this.faceText + ",faceType=" + this.faceType + ",}";
    }

    public ReplyAbsFaceElement(int i2, String str, int i3) {
        this.faceIndex = i2;
        this.faceText = str;
        this.faceType = i3;
    }
}
