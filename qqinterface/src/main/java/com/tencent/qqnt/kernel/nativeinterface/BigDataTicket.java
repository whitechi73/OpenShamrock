package com.tencent.qqnt.kernel.nativeinterface;

public final class BigDataTicket {
    public String sessionKey;
    public String sessionSig;

    public BigDataTicket() {
        this.sessionSig = "";
        this.sessionKey = "";
    }

    public String getSessionKey() {
        return this.sessionKey;
    }

    public String getSessionSig() {
        return this.sessionSig;
    }

    public String toString() {
        return "BigDataTicket{sessionSig=" + this.sessionSig + ",sessionKey=" + this.sessionKey + ",}";
    }

    public BigDataTicket(String str, String str2) {
        this.sessionSig = "";
        this.sessionKey = "";
        this.sessionSig = str;
        this.sessionKey = str2;
    }
}