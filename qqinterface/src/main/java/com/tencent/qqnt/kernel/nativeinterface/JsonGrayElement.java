package com.tencent.qqnt.kernel.nativeinterface;


public  final class JsonGrayElement {
    long busiId;
    boolean isServer;
    String jsonStr;
    String recentAbstract;
    XmlToJsonParam xmlToJsonParam;

    public JsonGrayElement() {
        this.jsonStr = "";
        this.recentAbstract = "";
    }

    public long getBusiId() {
        return this.busiId;
    }

    public boolean getIsServer() {
        return this.isServer;
    }

    public String getJsonStr() {
        return this.jsonStr;
    }

    public String getRecentAbstract() {
        return this.recentAbstract;
    }

    public XmlToJsonParam getXmlToJsonParam() {
        return this.xmlToJsonParam;
    }

    public String toString() {
        return "JsonGrayElement{busiId=" + this.busiId + ",jsonStr=" + this.jsonStr + ",recentAbstract=" + this.recentAbstract + ",isServer=" + this.isServer + ",xmlToJsonParam=" + this.xmlToJsonParam + ",}";
    }

    public JsonGrayElement(long j2, String str, String str2, boolean z, XmlToJsonParam xmlToJsonParam) {
        this.jsonStr = "";
        this.recentAbstract = "";
        this.busiId = j2;
        this.jsonStr = str;
        this.recentAbstract = str2;
        this.isServer = z;
        this.xmlToJsonParam = xmlToJsonParam;
    }
}
