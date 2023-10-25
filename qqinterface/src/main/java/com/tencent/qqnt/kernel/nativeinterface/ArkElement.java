package com.tencent.qqnt.kernel.nativeinterface;

public final class ArkElement {
    String bytesData;
    LinkInfo linkInfo;
    Integer subElementType;

    public ArkElement() {
        this.bytesData = "";
    }

    public String getBytesData() {
        return this.bytesData;
    }

    public LinkInfo getLinkInfo() {
        return this.linkInfo;
    }

    public Integer getSubElementType() {
        return this.subElementType;
    }

    public String toString() {
        return "ArkElement{bytesData=" + this.bytesData + ",linkInfo=" + this.linkInfo + ",subElementType=" + this.subElementType + ",}";
    }

    public ArkElement(String data, LinkInfo linkInfo, Integer num) {
        this.bytesData = data;
        this.linkInfo = linkInfo;
        this.subElementType = num;
    }
}