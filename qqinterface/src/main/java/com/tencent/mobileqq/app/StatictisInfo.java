package com.tencent.mobileqq.app;

public class StatictisInfo {
    public static final long DETAIL_REASON_DECODE_FAIL = 2139062143;
    public static final long DETAIL_REASON_UNKNOWN = 2139062142;
    public static final long NO_DETAIL_REASON = Long.MAX_VALUE;
    public static final int REPORT_AS_SUCC_FLAG = 1;
    public int appSeq = 0;
    public int errCode = 1000;
    public int retryCount = 0;
    public long detailErrorReason = Long.MAX_VALUE;
    public String timeoutReason = null;
    public int reportSucc = -1;
}
