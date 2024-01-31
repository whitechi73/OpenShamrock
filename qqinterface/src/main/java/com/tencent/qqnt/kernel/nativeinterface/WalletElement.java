package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;



public final class WalletElement {
    String authkey;
    String billNo;
    int channelId;
    int confType;
    int envelopeId;
    int grabState;
    long grabbedAmount;
    ArrayList<Long> grapUin;
    int msgFrom;
    int msgPriority;
    int msgType;
    String name;
    byte[] pbReserve;
    byte[] pcBody;
    WalletAio receiver;
    int redChannel;
    int redType;
    int resend;
    long sendUin;
    WalletAio sender;
    int sessiontype;
    byte[] stringIndex;
    int templateId;

    public WalletElement() {
        this.sender = new WalletAio();
        this.receiver = new WalletAio();
        this.billNo = "";
        this.authkey = "";
        this.name = "";
        this.pcBody = new byte[0];
        this.stringIndex = new byte[0];
        this.grapUin = new ArrayList<>();
        this.pbReserve = new byte[0];
    }

    public String getAuthkey() {
        return this.authkey;
    }

    public String getBillNo() {
        return this.billNo;
    }

    public int getChannelId() {
        return this.channelId;
    }

    public int getConfType() {
        return this.confType;
    }

    public int getEnvelopeId() {
        return this.envelopeId;
    }

    public int getGrabState() {
        return this.grabState;
    }

    public long getGrabbedAmount() {
        return this.grabbedAmount;
    }

    public ArrayList<Long> getGrapUin() {
        return this.grapUin;
    }

    public int getMsgFrom() {
        return this.msgFrom;
    }

    public int getMsgPriority() {
        return this.msgPriority;
    }

    public int getMsgType() {
        return this.msgType;
    }

    public String getName() {
        return this.name;
    }

    public byte[] getPbReserve() {
        return this.pbReserve;
    }

    public byte[] getPcBody() {
        return this.pcBody;
    }

    public WalletAio getReceiver() {
        return this.receiver;
    }

    public int getRedChannel() {
        return this.redChannel;
    }

    public int getRedType() {
        return this.redType;
    }

    public int getResend() {
        return this.resend;
    }

    public long getSendUin() {
        return this.sendUin;
    }

    public WalletAio getSender() {
        return this.sender;
    }

    public int getSessiontype() {
        return this.sessiontype;
    }

    public byte[] getStringIndex() {
        return this.stringIndex;
    }

    public int getTemplateId() {
        return this.templateId;
    }

    public String toString() {
        return "WalletElement{sendUin=" + this.sendUin + ",sender=" + this.sender + ",receiver=" + this.receiver + ",channelId=" + this.channelId + ",templateId=" + this.templateId + ",resend=" + this.resend + ",msgPriority=" + this.msgPriority + ",redType=" + this.redType + ",billNo=" + this.billNo + ",authkey=" + this.authkey + ",sessiontype=" + this.sessiontype + ",msgType=" + this.msgType + ",envelopeId=" + this.envelopeId + ",name=" + this.name + ",confType=" + this.confType + ",msgFrom=" + this.msgFrom + ",pcBody=" + this.pcBody + ",stringIndex=" + this.stringIndex + ",redChannel=" + this.redChannel + ",grapUin=" + this.grapUin + ",pbReserve=" + this.pbReserve + ",grabState=" + this.grabState + ",grabbedAmount=" + this.grabbedAmount + ",}";
    }

    public WalletElement(long j2, WalletAio walletAio, WalletAio walletAio2, int i2, int i3, int i4, int i5, int i6, String str, String str2, int i7, int i8, int i9, String str3, int i10, int i11, byte[] bArr, byte[] bArr2, int i12, ArrayList<Long> arrayList, byte[] bArr3, int i13, long j3) {
        this.sender = new WalletAio();
        this.receiver = new WalletAio();
        this.billNo = "";
        this.authkey = "";
        this.name = "";
        this.pcBody = new byte[0];
        this.stringIndex = new byte[0];
        this.grapUin = new ArrayList<>();
        this.pbReserve = new byte[0];
        this.sendUin = j2;
        this.sender = walletAio;
        this.receiver = walletAio2;
        this.channelId = i2;
        this.templateId = i3;
        this.resend = i4;
        this.msgPriority = i5;
        this.redType = i6;
        this.billNo = str;
        this.authkey = str2;
        this.sessiontype = i7;
        this.msgType = i8;
        this.envelopeId = i9;
        this.name = str3;
        this.confType = i10;
        this.msgFrom = i11;
        this.pcBody = bArr;
        this.stringIndex = bArr2;
        this.redChannel = i12;
        this.grapUin = arrayList;
        this.pbReserve = bArr3;
        this.grabState = i13;
        this.grabbedAmount = j3;
    }
}
