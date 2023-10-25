package VIP;

import com.qq.jce.JceStruct;

public final class GetCustomOnlineStatusRsp extends JceStruct {
    public int iRet;
    public String sBuffer;
    public String sMsg;

    public GetCustomOnlineStatusRsp() {
        this.iRet = 0;
        this.sMsg = "";
        this.sBuffer = "";
    }
}
