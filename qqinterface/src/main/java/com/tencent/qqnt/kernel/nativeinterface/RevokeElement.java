package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;


public  final class RevokeElement implements Serializable {
    boolean isSelfOperate;
    String operatorMemRemark;
    String operatorNick;
    String operatorRemark;
    long operatorRole;
    long operatorTinyId;
    String operatorUid;
    String origMsgSenderUid;
    long serialVersionUID;
    String wording;

    public RevokeElement() {
        this.serialVersionUID = 1L;
        this.operatorUid = "";
        this.origMsgSenderUid = "";
        this.wording = "";
    }

    public boolean getIsSelfOperate() {
        return this.isSelfOperate;
    }

    public String getOperatorMemRemark() {
        return this.operatorMemRemark;
    }

    public String getOperatorNick() {
        return this.operatorNick;
    }

    public String getOperatorRemark() {
        return this.operatorRemark;
    }

    public long getOperatorRole() {
        return this.operatorRole;
    }

    public long getOperatorTinyId() {
        return this.operatorTinyId;
    }

    public String getOperatorUid() {
        return this.operatorUid;
    }

    public String getOrigMsgSenderUid() {
        return this.origMsgSenderUid;
    }

    public String getWording() {
        return this.wording;
    }

    public String toString() {
        return "RevokeElement{operatorTinyId=" + this.operatorTinyId + ",operatorRole=" + this.operatorRole + ",operatorUid=" + this.operatorUid + ",operatorNick=" + this.operatorNick + ",operatorRemark=" + this.operatorRemark + ",operatorMemRemark=" + this.operatorMemRemark + ",origMsgSenderUid=" + this.origMsgSenderUid + ",isSelfOperate=" + this.isSelfOperate + ",wording=" + this.wording + ",}";
    }

    public RevokeElement(long j2, long j3, String str, String str2, String str3, String str4, String str5, boolean z, String str6) {
        this.serialVersionUID = 1L;
        this.operatorUid = "";
        this.origMsgSenderUid = "";
        this.wording = "";
        this.operatorTinyId = j2;
        this.operatorRole = j3;
        this.operatorUid = str;
        this.operatorNick = str2;
        this.operatorRemark = str3;
        this.operatorMemRemark = str4;
        this.origMsgSenderUid = str5;
        this.isSelfOperate = z;
        this.wording = str6;
    }
}
