package com.tencent.qqnt.kernel.nativeinterface;

public final class DeviceType {
    private static final  DeviceType[] $VALUES;
    public static final DeviceType KCOMPUTER;
    public static final DeviceType KPAD;
    public static final DeviceType KPHONE;
    public static final DeviceType KUNKNOWN;

    static {
        DeviceType deviceType = new DeviceType("KUNKNOWN", 0);
        KUNKNOWN = deviceType;
        DeviceType deviceType2 = new DeviceType("KPHONE", 1);
        KPHONE = deviceType2;
        DeviceType deviceType3 = new DeviceType("KPAD", 2);
        KPAD = deviceType3;
        DeviceType deviceType4 = new DeviceType("KCOMPUTER", 3);
        KCOMPUTER = deviceType4;
        $VALUES = new DeviceType[]{deviceType, deviceType2, deviceType3, deviceType4};
    }

    DeviceType(String str, int i2) {
    }

    public static DeviceType valueOf(String str) {
        return null;
    }

    public static DeviceType[] values() {
        return (DeviceType[]) $VALUES.clone();
    }
}
