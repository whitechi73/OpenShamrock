package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public final class AioOperateGrayTipElement implements Serializable {
    String fromGrpCodeOfTmpChat;
    int operateType;
    String peerUid;
    long serialVersionUID;

    public AioOperateGrayTipElement() {
        this.serialVersionUID = 1L;
        this.peerUid = "";
        this.fromGrpCodeOfTmpChat = "";
    }

    public String getFromGrpCodeOfTmpChat() {
        return this.fromGrpCodeOfTmpChat;
    }

    public int getOperateType() {
        return this.operateType;
    }

    public String getPeerUid() {
        return this.peerUid;
    }

    public String toString() {
        return "AioOperateGrayTipElement{operateType=" + this.operateType + ",peerUid=" + this.peerUid + ",fromGrpCodeOfTmpChat=" + this.fromGrpCodeOfTmpChat + ",}";
    }

    public AioOperateGrayTipElement(int i2, String str, String str2) {
        this.serialVersionUID = 1L;
        this.peerUid = "";
        this.fromGrpCodeOfTmpChat = "";
        this.operateType = i2;
        this.peerUid = str;
        this.fromGrpCodeOfTmpChat = str2;
    }
}