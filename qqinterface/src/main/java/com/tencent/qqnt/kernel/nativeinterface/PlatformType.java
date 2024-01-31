package com.tencent.qqnt.kernel.nativeinterface;

public final class PlatformType {
    private static final  PlatformType[] $VALUES;
    public static final PlatformType KANDROID;
    public static final PlatformType KIOS;
    public static final PlatformType KMAC;
    public static final PlatformType KUNKNOWN;
    public static final PlatformType KWINDOWS;

    static {
        PlatformType platformType = new PlatformType("KUNKNOWN", 0);
        KUNKNOWN = platformType;
        PlatformType platformType2 = new PlatformType("KANDROID", 1);
        KANDROID = platformType2;
        PlatformType platformType3 = new PlatformType("KIOS", 2);
        KIOS = platformType3;
        PlatformType platformType4 = new PlatformType("KWINDOWS", 3);
        KWINDOWS = platformType4;
        PlatformType platformType5 = new PlatformType("KMAC", 4);
        KMAC = platformType5;
        $VALUES = new PlatformType[]{platformType, platformType2, platformType3, platformType4, platformType5};
    }

    PlatformType(String str, int i2) {
    }

    public static PlatformType valueOf(String str) {
        return null;
    }

    public static PlatformType[] values() {
        return (PlatformType[]) $VALUES.clone();
    }
}
