package com.tencent.mobileqq.utils;

import android.content.Context;

public class SilkCodecWrapper {
    public SilkCodecWrapper(Context context, boolean isEncoder) {
    }

    public native long SilkDecoderNew(int sampleRate, int bitRate);

    public native long SilkEncoderNew(int sampleRate, int bitRate);

    public native int decode(long j2, byte[] bArr, byte[] bArr2, int i2, int i3);

    public native void deleteCodec(long j2);

    public native int encode(long j2, byte[] bArr, byte[] bArr2, int i2);

    public void release() {
    }
}
