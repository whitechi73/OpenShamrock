package com.tencent.qqnt.kernel.nativeinterface;


public  final class LocalMsgInfo {
    String localResId;

    public LocalMsgInfo() {
    }

    public String getLocalResId() {
        return this.localResId;
    }

    public String toString() {
        return "LocalMsgInfo{localResId=" + this.localResId + ",}";
    }

    public LocalMsgInfo(String str) {
        this.localResId = str;
    }
}
