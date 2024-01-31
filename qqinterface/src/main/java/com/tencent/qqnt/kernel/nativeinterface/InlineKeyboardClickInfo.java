package com.tencent.qqnt.kernel.nativeinterface;


public  final class InlineKeyboardClickInfo {
    long botAppid;
    String buttonId;
    String callbackData;
    int chatType;
    int dmFlag;
    String guildId;
    long msgSeq;
    String peerId;

    public InlineKeyboardClickInfo() {
        this.guildId = "";
        this.peerId = "";
        this.buttonId = "";
        this.callbackData = "";
    }

    public long getBotAppid() {
        return this.botAppid;
    }

    public String getButtonId() {
        return this.buttonId;
    }

    public String getCallbackData() {
        return this.callbackData;
    }

    public int getChatType() {
        return this.chatType;
    }

    public int getDmFlag() {
        return this.dmFlag;
    }

    public String getGuildId() {
        return this.guildId;
    }

    public long getMsgSeq() {
        return this.msgSeq;
    }

    public String getPeerId() {
        return this.peerId;
    }

    public String toString() {
        return "InlineKeyboardClickInfo{guildId=" + this.guildId + ",peerId=" + this.peerId + ",botAppid=" + this.botAppid + ",msgSeq=" + this.msgSeq + ",buttonId=" + this.buttonId + ",callbackData=" + this.callbackData + ",dmFlag=" + this.dmFlag + ",chatType=" + this.chatType + ",}";
    }

    public InlineKeyboardClickInfo(String str, String str2, long j2, long j3, String str3, String str4, int i2, int i3) {
        this.guildId = "";
        this.peerId = "";
        this.buttonId = "";
        this.callbackData = "";
        this.guildId = str;
        this.peerId = str2;
        this.botAppid = j2;
        this.msgSeq = j3;
        this.buttonId = str3;
        this.callbackData = str4;
        this.dmFlag = i2;
        this.chatType = i3;
    }
}
