package com.tencent.qqnt.kernel.nativeinterface;


public  final class ReplyAbsElement {
    ReplyAbsFaceElement faceElem;
    int replyAbsElemType;
    String textElemContent;

    public ReplyAbsElement() {
    }

    public ReplyAbsFaceElement getFaceElem() {
        return this.faceElem;
    }

    public int getReplyAbsElemType() {
        return this.replyAbsElemType;
    }

    public String getTextElemContent() {
        return this.textElemContent;
    }

    public String toString() {
        return "ReplyAbsElement{replyAbsElemType=" + this.replyAbsElemType + ",textElemContent=" + this.textElemContent + ",faceElem=" + this.faceElem + ",}";
    }

    public ReplyAbsElement(int i2, String str, ReplyAbsFaceElement replyAbsFaceElement) {
        this.replyAbsElemType = i2;
        this.textElemContent = str;
        this.faceElem = replyAbsFaceElement;
    }
}
