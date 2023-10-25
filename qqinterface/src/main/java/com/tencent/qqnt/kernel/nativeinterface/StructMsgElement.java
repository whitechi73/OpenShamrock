package com.tencent.qqnt.kernel.nativeinterface;

public final class StructMsgElement {
    String xmlContent;

    public StructMsgElement() {
    }

    public String getXmlContent() {
        return this.xmlContent;
    }

    public String toString() {
        return "StructMsgElement{xmlContent=" + this.xmlContent + ",}";
    }

    public StructMsgElement(String str) {
        this.xmlContent = str;
    }
}
