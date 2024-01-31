package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public  final class GProRecommendMsg implements Serializable {
    String avatar;
    long msgSeq;
    String nickName;
    byte[] richText;
    long serialVersionUID;
    long tinyid;

    public GProRecommendMsg() {
        this.serialVersionUID = 1L;
        this.nickName = "";
        this.avatar = "";
        this.richText = new byte[0];
    }

    public String getAvatar() {
        return this.avatar;
    }

    public long getMsgSeq() {
        return this.msgSeq;
    }

    public String getNickName() {
        return this.nickName;
    }

    public byte[] getRichText() {
        return this.richText;
    }

    public long getTinyid() {
        return this.tinyid;
    }

    public String toString() {
        return "GProRecommendMsg{tinyid=" + this.tinyid + ",nickName=" + this.nickName + ",avatar=" + this.avatar + ",msgSeq=" + this.msgSeq + ",richText=" + this.richText + ",}";
    }

    public GProRecommendMsg(long j2, String str, String str2, long j3, byte[] bArr) {
        this.serialVersionUID = 1L;
        this.nickName = "";
        this.avatar = "";
        this.richText = new byte[0];
        this.tinyid = j2;
        this.nickName = str;
        this.avatar = str2;
        this.msgSeq = j3;
        this.richText = bArr;
    }
}
