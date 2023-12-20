package com.tencent.mobileqq.transfile;

import java.util.HashMap;

public class NetResp {
    public static final String KEY_FIRST_USE_IP = "firstserverip";
    public static final String KEY_RAW_REQ_HTTP_HEADER = "param_reqHeader";
    public static final String KEY_RAW_RESP_HTTP_HEADER = "param_rspHeader";
    public static final String KEY_REASON = "netresp_param_reason";
    public static final String KEY_USE_SERVER_IP = "serverip";
    public static final String KEY_USE_URL = "param_url";
    public static final int RESULT_DOWNLOADING = 3;
    public static final int RESULT_FAIL = 1;
    public static final int RESULT_NOT_SET = 2;
    public static final int RESULT_OK = 0;
    public long inQueueCost;
    public long mConsumeTime;
    public int mErrCode;
    public String mErrDesc;
    public int mHttpCode;
    public long mLastReqStartTime;
    public int mRedirectCount;
    public long mRedirectTime;
    public NetReq mReq;
    public byte[] mRespData;
    public HashMap<String, String> mRespProperties;
    public int mResult;
    public long mTotalBlockLen;
    public long mTotalFileLen;
    public int mTryTime;
    public long mWrittenBlockLen;
    public long reqCost;

    public NetResp(NetReq netReq) {
        this.mResult = 2;
        this.mTotalFileLen = 0L;
        this.mTotalBlockLen = 0L;
        this.mWrittenBlockLen = 0L;
        this.mConsumeTime = 0L;
        this.mTryTime = 0;
        this.mRespProperties = new HashMap<>();
        this.mRedirectCount = 0;
        this.mRedirectTime = 0L;
        this.reqCost = 0L;
        this.inQueueCost = 0L;
        this.mReq = netReq;
        this.mLastReqStartTime = System.currentTimeMillis();
    }

    public void reset() {
        this.mResult = 2;
        this.mErrCode = 0;
        this.mErrDesc = "";
        this.mHttpCode = 0;
        this.mTotalFileLen = 0L;
        this.mTotalBlockLen = 0L;
        this.mWrittenBlockLen = 0L;
        this.mConsumeTime = 0L;
        this.mTryTime = 0;
        this.mRespData = null;
        this.mRespProperties.clear();
    }

    public void setResult(int i2, int i3, String str, HashMap<String, String> hashMap) {
        this.mResult = i2;
        this.mErrCode = i3;
        this.mErrDesc = str;
        if (hashMap != null) {
            this.mRespProperties.putAll(hashMap);
        }
    }
}
