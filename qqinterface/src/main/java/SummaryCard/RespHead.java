package SummaryCard;

import com.qq.jce.JceStruct;

public final class RespHead extends JceStruct {
    static byte[] cache_vCookies;
    public int iResult;
    public int iVersion;
    public String strErrorMsg;
    public byte[] vCookies;
}