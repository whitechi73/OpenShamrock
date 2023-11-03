package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes.dex */
public final class TempChatPrepareInfo {
    int chatType;
    String fromGroupCode;
    TempChatGameSession gameSession;
    String peerNickname;
    String peerUid;
    String selfPhone;
    String selfUid;
    byte[] sig;

    public TempChatPrepareInfo() {
        this.peerUid = "";
        this.peerNickname = "";
        this.fromGroupCode = "";
        this.sig = new byte[0];
        this.selfUid = "";
        this.selfPhone = "";
    }

    public int getChatType() {
        return this.chatType;
    }

    public String getFromGroupCode() {
        return this.fromGroupCode;
    }

    public TempChatGameSession getGameSession() {
        return this.gameSession;
    }

    public String getPeerNickname() {
        return this.peerNickname;
    }

    public String getPeerUid() {
        return this.peerUid;
    }

    public String getSelfPhone() {
        return this.selfPhone;
    }

    public String getSelfUid() {
        return this.selfUid;
    }

    public byte[] getSig() {
        return this.sig;
    }

    public String toString() {
        return "TempChatPrepareInfo{chatType=" + this.chatType + ",peerUid=" + this.peerUid + ",peerNickname=" + this.peerNickname + ",fromGroupCode=" + this.fromGroupCode + ",sig=" + this.sig + ",selfUid=" + this.selfUid + ",selfPhone=" + this.selfPhone + ",gameSession=" + this.gameSession + ",}";
    }

    public TempChatPrepareInfo(int chatType, String peerId, String nickName, String fromGroup, byte[] sig, String selfUid, String selfPhone, TempChatGameSession session) {
        this.chatType = chatType;
        this.peerUid = peerId;
        this.peerNickname = nickName;
        this.fromGroupCode = fromGroup;
        this.sig = sig;
        this.selfUid = selfUid;
        this.selfPhone = selfPhone;
        this.gameSession = session;
    }
}
