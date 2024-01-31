package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;


public  final class RichText {
    ArrayList<RichTextContent> contents;

    public RichText() {
        this.contents = new ArrayList<>();
    }

    public ArrayList<RichTextContent> getContents() {
        return this.contents;
    }

    public String toString() {
        return "RichText{contents=" + this.contents + ",}";
    }

    public RichText(ArrayList<RichTextContent> arrayList) {
        this.contents = new ArrayList<>();
        this.contents = arrayList;
    }
}
