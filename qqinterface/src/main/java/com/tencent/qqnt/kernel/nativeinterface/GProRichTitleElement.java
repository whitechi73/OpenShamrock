package com.tencent.qqnt.kernel.nativeinterface;



/* loaded from: classes2.dex */
public final class GProRichTitleElement {
    String text;
    Integer type;
    String url;

    public GProRichTitleElement() {
    }

    public String getText() {
        return this.text;
    }

    public Integer getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "GProRichTitleElement{type=" + this.type + ",text=" + this.text + ",url = " + this.url + ",}";
    }

    public GProRichTitleElement(Integer num, String str, String str2) {
        this.type = num;
        this.text = str;
        this.url = str2;
    }
}
