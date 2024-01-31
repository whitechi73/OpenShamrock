package com.tencent.qqnt.kernel.nativeinterface;



public final class StructLongMsgElement {
    String resId;
    String xmlContent;

    public StructLongMsgElement() {
    }

    public String getResId() {
        return this.resId;
    }

    public String getXmlContent() {
        return this.xmlContent;
    }

    public String toString() {
        return "StructLongMsgElement{xmlContent=" + this.xmlContent + ",resId=" + this.resId + ",}";
    }

    public StructLongMsgElement(String str, String str2) {
        this.xmlContent = str;
        this.resId = str2;
    }
}
