package com.tencent.mobileqq.transfile;

public class HttpNetReq extends NetReq {
    public static final int HTTP_GET = 0;
    public static final int HTTP_POST = 1;
    public IFlowDecoder decoder;
    public DnsParseCallback mDnsParseCallback;
    public boolean mHaveIpConnect;
    public String mHostForHttpsVerify;
    public int mHttpMethod;
    public boolean mIsHostIP;
    public boolean mIsHttps;
    public boolean mIsPreStructPic;
    public boolean mIsSync;
    public boolean mNeedIpConnect;
    public boolean mNeedNotReferer;
    public boolean mNeedRedirectCallback;
    public String mReqUrl;
    public TimeoutParam mTimeoutParam;
    public boolean mUseCmwapConnectionTypeFromDpc;
    public String[] mWhiteListContentType;

    public interface DecoderState {
        public static final int STATE_END = 2;
        public static final int STATE_INIT = 0;
        public static final int STATE_RUNNING = 1;
    }

    public interface DnsParseCallback {
        void end();

        void start();
    }

    public interface IFlowDecoder {
        byte[] decode(byte[] bArr);

        boolean isFinish();

        void reset();
    }

    public HttpNetReq() {
        this.mHttpMethod = 0;
        this.mNeedIpConnect = false;
        this.mHaveIpConnect = false;
        this.mNeedRedirectCallback = false;
        this.mUseCmwapConnectionTypeFromDpc = false;
        this.mNeedNotReferer = false;
    }
}
