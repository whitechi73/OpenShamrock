package com.tencent.qqnt.kernel.nativeinterface;

public  final class PublicAccountAttrs {
    Integer ack;
    Long bitmap;
    byte[] gdtCliData;
    byte[] gdtImpData;
    Integer op;
    Long pubMsgId;
    Integer report;
    Integer showTime;
    Long uniqueId;
    byte[] viewId;

    public PublicAccountAttrs() {
    }

    public Integer getAck() {
        return this.ack;
    }

    public Long getBitmap() {
        return this.bitmap;
    }

    public byte[] getGdtCliData() {
        return this.gdtCliData;
    }

    public byte[] getGdtImpData() {
        return this.gdtImpData;
    }

    public Integer getOp() {
        return this.op;
    }

    public Long getPubMsgId() {
        return this.pubMsgId;
    }

    public Integer getReport() {
        return this.report;
    }

    public Integer getShowTime() {
        return this.showTime;
    }

    public Long getUniqueId() {
        return this.uniqueId;
    }

    public byte[] getViewId() {
        return this.viewId;
    }

    public String toString() {
        return "PublicAccountAttrs{pubMsgId=" + this.pubMsgId + ",uniqueId=" + this.uniqueId + ",op=" + this.op + ",showTime=" + this.showTime + ",report=" + this.report + ",ack=" + this.ack + ",bitmap=" + this.bitmap + ",gdtImpData=" + this.gdtImpData + ",gdtCliData=" + this.gdtCliData + ",viewId=" + this.viewId + ",}";
    }

    public PublicAccountAttrs(Long l2, Long l3, Integer num, Integer num2, Integer num3, Integer num4, Long l4, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.pubMsgId = l2;
        this.uniqueId = l3;
        this.op = num;
        this.showTime = num2;
        this.report = num3;
        this.ack = num4;
        this.bitmap = l4;
        this.gdtImpData = bArr;
        this.gdtCliData = bArr2;
        this.viewId = bArr3;
    }
}
