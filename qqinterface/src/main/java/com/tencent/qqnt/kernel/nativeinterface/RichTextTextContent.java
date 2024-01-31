package com.tencent.qqnt.kernel.nativeinterface;


public  final class RichTextTextContent {
    String text;

    public RichTextTextContent() {
        this.text = "";
    }

    public String getText() {
        return this.text;
    }

    public String toString() {
        return "RichTextTextContent{text=" + this.text + ",}";
    }

    public RichTextTextContent(String str) {
        this.text = "";
        this.text = str;
    }
}
