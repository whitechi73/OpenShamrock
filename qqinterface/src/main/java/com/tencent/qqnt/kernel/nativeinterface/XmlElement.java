package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.HashMap;



public final class XmlElement implements Serializable {
    long busiId;
    long busiType;
    int c2cType;
    String content;
    int ctrlFlag;
    HashMap<String, String> members;
    byte[] pbReserv;
    Long seqId;
    long serialVersionUID;
    int serviceType;
    Long templId;
    HashMap<String, String> templParam;

    public XmlElement() {
        this.serialVersionUID = 1L;
        this.content = "";
    }

    public long getBusiId() {
        return this.busiId;
    }

    public long getBusiType() {
        return this.busiType;
    }

    public int getC2cType() {
        return this.c2cType;
    }

    public String getContent() {
        return this.content;
    }

    public int getCtrlFlag() {
        return this.ctrlFlag;
    }

    public HashMap<String, String> getMembers() {
        return this.members;
    }

    public byte[] getPbReserv() {
        return this.pbReserv;
    }

    public Long getSeqId() {
        return this.seqId;
    }

    public int getServiceType() {
        return this.serviceType;
    }

    public Long getTemplId() {
        return this.templId;
    }

    public HashMap<String, String> getTemplParam() {
        return this.templParam;
    }

    public String toString() {
        return "XmlElement{busiType=" + this.busiType + ",busiId=" + this.busiId + ",c2cType=" + this.c2cType + ",serviceType=" + this.serviceType + ",ctrlFlag=" + this.ctrlFlag + ",content=" + this.content + ",templId=" + this.templId + ",seqId=" + this.seqId + ",templParam=" + this.templParam + ",pbReserv=" + this.pbReserv + ",members=" + this.members + ",}";
    }

    public XmlElement(long j2, long j3, int i2, int i3, int i4, String str, Long l2, Long l3, HashMap<String, String> hashMap, byte[] bArr, HashMap<String, String> hashMap2) {
        this.serialVersionUID = 1L;
        this.content = "";
        this.busiType = j2;
        this.busiId = j3;
        this.c2cType = i2;
        this.serviceType = i3;
        this.ctrlFlag = i4;
        this.content = str;
        this.templId = l2;
        this.seqId = l3;
        this.templParam = hashMap;
        this.pbReserv = bArr;
        this.members = hashMap2;
    }
}
