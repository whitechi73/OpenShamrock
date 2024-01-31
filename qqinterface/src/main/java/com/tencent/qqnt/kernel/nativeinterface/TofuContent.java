package com.tencent.qqnt.kernel.nativeinterface;



public final class TofuContent {
    String color;
    String title;

    public TofuContent() {
    }

    public String getColor() {
        return this.color;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "TofuContent{title=" + this.title + ",color=" + this.color + ",}";
    }

    public TofuContent(String str, String str2) {
        this.title = str;
        this.color = str2;
    }
}
