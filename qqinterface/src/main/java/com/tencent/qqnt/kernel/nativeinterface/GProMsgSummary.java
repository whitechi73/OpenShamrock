package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* loaded from: classes2.dex */
public final class GProMsgSummary implements Serializable {
    String avatar;
    long msgSeq;
    byte[] richText;
    long serialVersionUID;
    long tinyId;

    public GProMsgSummary() {
        this.serialVersionUID = 1L;
        this.avatar = "";
        this.richText = new byte[0];
    }

    public String getAvatar() {
        return this.avatar;
    }

    public long getMsgSeq() {
        return this.msgSeq;
    }

    public byte[] getRichText() {
        return this.richText;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public String toString() {
        return "GProMsgSummary{tinyId=" + this.tinyId + ",avatar=" + this.avatar + ",msgSeq=" + this.msgSeq + ",richText=" + this.richText + ",}";
    }

    public GProMsgSummary(long j2, String str, long j3, byte[] bArr) {
        this.serialVersionUID = 1L;
        this.avatar = "";
        this.richText = new byte[0];
        this.tinyId = j2;
        this.avatar = str;
        this.msgSeq = j3;
        this.richText = bArr;
    }
}
