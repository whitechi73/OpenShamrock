package com.tencent.qqnt.kernel.nativeinterface;


public  final class RichTextURLContent {
    String displayText;
    String url;

    public RichTextURLContent() {
        this.url = "";
        this.displayText = "";
    }

    public String getDisplayText() {
        return this.displayText;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "RichTextURLContent{url=" + this.url + ",displayText=" + this.displayText + ",}";
    }

    public RichTextURLContent(String str, String str2) {
        this.url = "";
        this.displayText = "";
        this.url = str;
        this.displayText = str2;
    }
}
