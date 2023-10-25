package QQService;

import com.qq.jce.JceStruct;

public final class SvcDevLoginInfo extends JceStruct {
    static DeviceItemDes cache_stDeviceItemDes = new DeviceItemDes();
    static byte[] cache_vecGuid;
    public long iAppId;
    public long iCanBeKicked;
    public long iLoginPlatform;
    public long iLoginTime;
    public long iProductType;
    public long iTerType;
    public DeviceItemDes stDeviceItemDes;
    public String strDeviceName;
    public String strDeviceTypeInfo;
    public String strLoginLocation;
    public byte[] vecGuid;
}