package com.tencent.mobileqq.transfile;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;

public class NetReq {
    public static final int PRIOTY_HIGH = 0;
    public static final int PRIOTY_LOW = 2;
    public static final int PRIOTY_NORMAL = 1;
    public boolean bAcceptNegativeContentLength;
    public int mBusiProtoType;
    public INetEngineListener mCallback;
    public boolean mCanPrintUrl;
    public int mContinuErrorLimit;
    public int mContinueConnReusedErrorLimit;
    public long mDelayTime;
    public long mEndDownOffset;
    public long mExcuteTimeLimit;
    public NetFailedListener mFailedListener;
    public int mFileType;
    public HostParseToIp mHostParseToIp;
    public boolean mIsNetChgAsError;
    public boolean mIsRenameInEngine;
    public String mKey;
    public String mMsgId;
    public String mOutPath;
    public OutputStream mOutStream;
    public int mPrioty;
    public Object mPrivate;
    public HashMap<String, String> mReqProperties;
    public NetResp mResp;
    public byte[] mSendData;
    public List<ServerAddr> mServerList;
    public long mStartDownOffset;
    public boolean mSupportBreakResume;
    public String mTempPath;
    public boolean mUseByteArrayPool;
    public boolean mUseRaf;
    private Object mUserData;
    public long taskStartTime;

    public interface HostParseToIp {
        List<ServerAddr> getIpByHost(String str);
    }

    public NetReq() {
        this.mStartDownOffset = 0L;
        this.mEndDownOffset = 0L;
        this.mIsRenameInEngine = true;
        this.mDelayTime = 0L;
        this.mExcuteTimeLimit = 480000L;
        this.mContinuErrorLimit = 8;
        this.mContinueConnReusedErrorLimit = 5;
        this.mIsNetChgAsError = false;
        this.mPrioty = 1;
        this.mResp = null;
        this.mCanPrintUrl = true;
        this.bAcceptNegativeContentLength = true;
        this.mUseByteArrayPool = false;
        this.mKey = null;
        this.taskStartTime = -1L;
        this.mReqProperties = new HashMap<>();
    }

    public long getTaskCostTime() {
        return System.currentTimeMillis() - taskStartTime;
    }

    public synchronized Object getUserData() {
        return mUserData;
    }

    public boolean isWriteToFile() {
        return this.mOutPath != null;
    }

    public boolean isWriteToStream() {
        return this.mOutStream != null;
    }

    public boolean saveRecvDataInTransLayer() {
        return this.mOutPath != null || this.mOutStream != null;
    }

    public synchronized void setUserData(Object obj) {
        this.mUserData = obj;
    }
}
