package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes2.dex */
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

    public MultiMsgInfo(long j2, String str) {
        this.msgId = j2;
        this.senderShowName = str;
    }
}
