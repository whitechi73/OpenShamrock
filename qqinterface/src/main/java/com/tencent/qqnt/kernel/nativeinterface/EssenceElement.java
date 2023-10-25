package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public final class EssenceElement implements Serializable {
    int isSetEssence;
    long msgSeq;
    long serialVersionUID = 1;
    long tinyId;

    public EssenceElement() {
    }

    public int getIsSetEssence() {
        return this.isSetEssence;
    }

    public long getMsgSeq() {
        return this.msgSeq;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public String toString() {
        return "EssenceElement{tinyId=" + this.tinyId + ",msgSeq=" + this.msgSeq + ",isSetEssence=" + this.isSetEssence + ",}";
    }

    public EssenceElement(long j2, long j3, int i2) {
        this.tinyId = j2;
        this.msgSeq = j3;
        this.isSetEssence = i2;
    }
}