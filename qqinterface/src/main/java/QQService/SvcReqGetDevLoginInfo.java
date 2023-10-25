package QQService;

import com.qq.jce.JceStruct;

public final class SvcReqGetDevLoginInfo extends JceStruct implements Cloneable {
    static final boolean $assertionsDisabled = false;
    static byte[] cache_vecGuid;
    public long iGetDevListType;
    public long iLoginType;
    public long iNextItemIndex;
    public long iRequireMax;
    public long iTimeStamp;
    public String strAppName;
    public byte[] vecGuid;

    public SvcReqGetDevLoginInfo() {
        this.vecGuid = null;
        this.strAppName = "";
        this.iLoginType = 1L;
        this.iTimeStamp = 0L;
        this.iNextItemIndex = 0L;
        this.iRequireMax = 0L;
        this.iGetDevListType = 7L;
    }
    /*
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.vecGuid, 0);
        jceOutputStream.write(this.strAppName, 1);
        jceOutputStream.write(this.iLoginType, 2);
        jceOutputStream.write(this.iTimeStamp, 3);
        jceOutputStream.write(this.iNextItemIndex, 4);
        jceOutputStream.write(this.iRequireMax, 5);
        jceOutputStream.write(this.iGetDevListType, 6);
    }*/
}