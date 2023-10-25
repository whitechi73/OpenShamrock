package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

public final class MsgAbstract implements Serializable {
    long abstractTime;
    ArrayList<MsgAbstractElement> elements;
    int msgType;
    Contact peer;
    String sendMemberName;
    String sendNickName;
    int sendStatus;
    String senderUid;
    long serialVersionUID;

    public MsgAbstract() {
        this.serialVersionUID = 1L;
        this.peer = new Contact();
        this.senderUid = "";
        this.sendMemberName = "";
        this.sendNickName = "";
        this.elements = new ArrayList<>();
    }

    public long getAbstractTime() {
        return this.abstractTime;
    }

    public ArrayList<MsgAbstractElement> getElements() {
        return this.elements;
    }

    public int getMsgType() {
        return this.msgType;
    }

    public Contact getPeer() {
        return this.peer;
    }

    public String getSendMemberName() {
        return this.sendMemberName;
    }

    public String getSendNickName() {
        return this.sendNickName;
    }

    public int getSendStatus() {
        return this.sendStatus;
    }

    public String getSenderUid() {
        return this.senderUid;
    }

    public String toString() {
        return "MsgAbstract{peer=" + this.peer + ",senderUid=" + this.senderUid + ",sendMemberName=" + this.sendMemberName + ",sendNickName=" + this.sendNickName + ",sendStatus=" + this.sendStatus + ",elements=" + this.elements + ",abstractTime=" + this.abstractTime + ",msgType=" + this.msgType + ",}";
    }

    public MsgAbstract(Contact contact, String str, String str2, String str3, int i2, ArrayList<MsgAbstractElement> arrayList, long j2, int i3) {
        this.serialVersionUID = 1L;
        this.peer = new Contact();
        this.senderUid = "";
        this.sendMemberName = "";
        this.sendNickName = "";
        this.elements = new ArrayList<>();
        this.peer = contact;
        this.senderUid = str;
        this.sendMemberName = str2;
        this.sendNickName = str3;
        this.sendStatus = i2;
        this.elements = arrayList;
        this.abstractTime = j2;
        this.msgType = i3;
    }
}