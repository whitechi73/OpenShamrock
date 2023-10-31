package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public final class Contact implements IKernelModel, Serializable {
    int chatType;
    String guildId;
    String peerUid;
    long serialVersionUID;

    public Contact() {
        this.serialVersionUID = 1L;
        this.peerUid = "";
        this.guildId = "";
    }

    public int getChatType() {
        return this.chatType;
    }

    public String getGuildId() {
        return this.guildId;
    }

    public String getPeerUid() {
        return this.peerUid;
    }

    public void setChatType(int i2) {
        this.chatType = i2;
    }

    public void setGuildId(String str) {
        this.guildId = str;
    }

    public void setPeerUid(String str) {
        this.peerUid = str;
    }

    public String toString() {
        return "Contact{chatType=" + this.chatType + ",peerUid=" + this.peerUid + ",guildId=" + this.guildId + ",}";
    }

    public Contact(int i2, String str, String str2) {
        this.serialVersionUID = 1L;
        this.chatType = i2;
        this.peerUid = str;
        this.guildId = str2;
    }
}