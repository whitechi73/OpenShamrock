package com.tencent.mobileqq.transfile;

public class TransferResult {
    public static final int RESULT_FAIL = -1;
    public static final int RESULT_NOT_SET = -2;
    public static final int RESULT_OK = 0;
    public long mErrCode;
    public String mErrDesc;
    public TransferRequest mOrigReq;
    public int mResult = -2;
}