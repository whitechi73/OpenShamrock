package com.qq.jce.wup;

public class UniPacket {
    public UniPacket() {
    }

    public String getFuncName() {
        return null;
    }

    public int getOldRespIret() {
        return 0;
    }

    public int getPackageVersion() {
        return 0;
    }

    public int getRequestId() {
        return 0;
    }

    public String getServantName() {
        return null;
    }

    public <T> void put(String str, T t) {
        throw new IllegalArgumentException("put name can not startwith . , now is " + str);
    }

    public void setFuncName(String str) {
    }

    public void setOldRespIret(int i2) {
    }

    public void setRequestId(int i2) {
    }

    public void setServantName(String str) {
    }

    public UniPacket(boolean z) {
    }

    public <T> T get(String str, T t, Object obj) {
        return null;
    }

    public <T> T getByClass(String str, T t) {
        return null;
    }

    public void decode(byte[] bArr) {
        throw new IllegalArgumentException("decode package must include size head");
    }

    public String getEncodeName() {
        return null;
    }

    public void setEncodeName(String str) {
    }

    public byte[] encode() {
        return null;
    }
}
