package com.tencent.qqnt.kernel.nativeinterface;

public final class MultiMsgInfo {
    long msgId;
    String senderShowName;

    public MultiMsgInfo() {
    }

    public long getMsgId() {
        return this.msgId;
    }

    public String getSenderShowName() {
        return this.senderShowName;
    }

    public String toString() {
        return "MultiMsgInfo{msgId=" + this.msgId + ",senderShowName=" + this.senderShowName + ",}";
    }

    public MultiMsgInfo(long msgId, String showName) {
    }
}
