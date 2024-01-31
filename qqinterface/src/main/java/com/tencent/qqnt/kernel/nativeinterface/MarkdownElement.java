package com.tencent.qqnt.kernel.nativeinterface;


public  final class MarkdownElement {
    String content;

    public MarkdownElement() {
        this.content = "";
    }

    public String getContent() {
        return this.content;
    }

    public String toString() {
        return "MarkdownElement{content=" + this.content + ",}";
    }

    public MarkdownElement(String str) {
        this.content = str;
    }
}
