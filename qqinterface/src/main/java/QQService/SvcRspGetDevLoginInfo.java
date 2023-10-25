package QQService;

import com.qq.jce.JceStruct;

import java.util.ArrayList;

public final class SvcRspGetDevLoginInfo extends JceStruct implements Cloneable {
    static final boolean $assertionsDisabled = false;
    static ArrayList<SvcDevLoginInfo> cache_vecAuthLoginDevInfo;
    static ArrayList<SvcDevLoginInfo> cache_vecCurrentLoginDevInfo;
    static ArrayList<SvcDevLoginInfo> cache_vecHistoryLoginDevInfo;
    public long iNextItemIndex;
    public int iResult;
    public long iTotalItemCount;
    public String strResult;
    public ArrayList<SvcDevLoginInfo> vecAuthLoginDevInfo;
    public ArrayList<SvcDevLoginInfo> vecCurrentLoginDevInfo;
    public ArrayList<SvcDevLoginInfo> vecHistoryLoginDevInfo;
}