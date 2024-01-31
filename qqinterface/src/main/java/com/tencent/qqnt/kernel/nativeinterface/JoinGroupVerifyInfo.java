package com.tencent.qqnt.kernel.nativeinterface;


public  final class JoinGroupVerifyInfo {
    JoinGroupVerifyType type;
    String url;

    public JoinGroupVerifyInfo() {
        this.type = JoinGroupVerifyType.values()[0];
        this.url = "";
    }

    public JoinGroupVerifyType getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public String toString() {
        return "JoinGroupVerifyInfo{type=" + this.type + ", url = " + this.url + ",}";
    }

    public JoinGroupVerifyInfo(JoinGroupVerifyType joinGroupVerifyType, String str) {
        this.type = JoinGroupVerifyType.values()[0];
        this.url = "";
        this.type = joinGroupVerifyType;
        this.url = str;
    }
}
