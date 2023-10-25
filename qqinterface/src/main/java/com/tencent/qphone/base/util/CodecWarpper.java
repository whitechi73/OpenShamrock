package com.tencent.qphone.base.util;

public abstract class CodecWarpper {
    public abstract void onResponse(int i2, Object obj, int i3);

    public abstract void onResponse(int i2, Object obj, int i3, byte[] bArr);

    public abstract int onSSOPingResponse(byte[] bArr, int i2);

    public abstract void onInvalidSign();
}
