package com.tencent.mobileqq.pb;

public abstract class PBField<T> {
    public static <T extends MessageMicro<T>> PBRepeatMessageField<T> initRepeatMessage(Class<T> cls) {
        return new PBRepeatMessageField<>(cls);
    }

    public static <T> PBRepeatField<T> initRepeat(PBField<T> pBField) {
        return new PBRepeatField<>(pBField);
    }

    public static PBUInt32Field initUInt32(int i2) {
        return new PBUInt32Field(i2, false);
    }

    public static PBStringField initString(String str) {
        return new PBStringField(str, false);
    }

    public static PBBytesField initBytes(ByteStringMicro byteStringMicro) {
        return new PBBytesField(byteStringMicro, false);
    }

    public static PBFloatField initFloat(float paramFloat) {
        return new PBFloatField(paramFloat, false);
    }

    public static PBBoolField initBool(boolean z) {
        return new PBBoolField(z, false);
    }

    public static PBInt32Field initInt32(int i2) {
        return new PBInt32Field(i2, false);
    }

    public static PBUInt64Field initUInt64(long j2) {
        return new PBUInt64Field(j2, false);
    }

    public static PBInt64Field initInt64(long j2) {
        return new PBInt64Field(j2, false);
    }

    public static PBEnumField initEnum(int i2) {
        return new PBEnumField(i2, false);
    }
}
