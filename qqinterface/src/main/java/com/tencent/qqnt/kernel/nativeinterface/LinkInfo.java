package com.tencent.qqnt.kernel.nativeinterface;

public final class LinkInfo {
    String icon;
    Integer tencentDocType;
    String title;

    public LinkInfo() {
    }

    public String getIcon() {
        return this.icon;
    }

    public Integer getTencentDocType() {
        return this.tencentDocType;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "LinkInfo{title=" + this.title + ",icon=" + this.icon + ",tencentDocType=" + this.tencentDocType + ",}";
    }

    public LinkInfo(String str, String str2, Integer num) {
        this.title = str;
        this.icon = str2;
        this.tencentDocType = num;
    }
}