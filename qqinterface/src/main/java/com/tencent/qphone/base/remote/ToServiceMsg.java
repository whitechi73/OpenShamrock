package com.tencent.qphone.base.remote;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import com.tencent.mobileqq.msf.sdk.MsfCommand;

import java.util.HashMap;

public class ToServiceMsg implements Parcelable {
    public static final Parcelable.Creator<ToServiceMsg> CREATOR = new Parcelable.Creator<ToServiceMsg>() {
        @Override
        public ToServiceMsg createFromParcel(Parcel parcel) {
            return new ToServiceMsg(parcel);
        }

        @Override
        public ToServiceMsg[] newArray(int i2) {
            return new ToServiceMsg[i2];
        }
    };
    private static final String KEY_FIRST_PKG_AFTER_CONN_OPEN = "key_first_pkg_after_conn_open";
    private static final String tag = "ToServiceMsg";
    private static final String version = "version";
    //public IBaseActionListener actionListener;
    private int appId;
    private int appSeq;
    private HashMap<String, Object> attributes;
    public Bundle extraData;
    private boolean mIsSupportRetry;
    public boolean mSkipBinderWhenMarshall;
    private int mSsoVersion;
    private MsfCommand msfCommand;
    private boolean needResp;
    private boolean quickSendEnable;
    private int quickSendStrategy;
    private long sendTimeout;
    private String serviceCmd;
    private String serviceName;
    private int ssoSeq;
    private long timeout;
    private byte toVersion;
    private HashMap<String, byte[]> transInfo;
    private String uin;
    private byte uinType;
    private byte[] wupBuffer;

    public ToServiceMsg(String service, String uin, String cmd) {

    }

    public synchronized Object addAttribute(String str, Object obj) {
        return this.attributes.put(str, obj);
    }

    public Object addTransInfo(String str, byte[] bArr) {
        return this.transInfo.put(str, bArr);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    //public IBaseActionListener getActionListener() {
    //    return this.actionListener;
    //}

    public int getAppId() {
        return this.appId;
    }

    public int getAppSeq() {
        return this.appSeq;
    }

    public Object getAttribute(String str) {
        return this.attributes.get(str);
    }

    public HashMap<String, Object> getAttributes() {
        return this.attributes;
    }

    public String getDestServiceId() {
        return this.serviceName;
    }

    public MsfCommand getMsfCommand() {
        return this.msfCommand;
    }

    public int getQuickSendStrategy() {
        return this.quickSendStrategy;
    }

    public int getRequestSsoSeq() {
        return this.ssoSeq;
    }

    public int getSSOVersion() {
        return this.mSsoVersion;
    }

    public long getSendTimeout() {
        return this.sendTimeout;
    }

    public String getServiceCmd() {
        return this.serviceCmd;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public String getShortStringForLog() {
        try {
            StringBuffer stringBuffer = new StringBuffer(256);
            stringBuffer.append(tag);
            stringBuffer.append(" ssoSeq:");
            stringBuffer.append(getRequestSsoSeq());
            stringBuffer.append(" sCmd:");
            stringBuffer.append(this.serviceCmd);
            stringBuffer.append(" appSeq:");
            stringBuffer.append(this.appSeq);
            stringBuffer.append(" t:");
            stringBuffer.append(this.timeout);
            stringBuffer.append(" needResp:");
            stringBuffer.append(this.needResp);
            stringBuffer.append(" needQuickSend:");
            stringBuffer.append(this.quickSendEnable);
            stringBuffer.append("IsSupportRetry");
            stringBuffer.append(this.mIsSupportRetry);
            return stringBuffer.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return "fsm getString error";
        }
    }

    public String getStringForLog() {
        return "TSM getString error";
    }

    public long getTimeout() {
        return this.timeout;
    }

    public String getTraceInfo() {
        return null;
    }

    public HashMap<String, byte[]> getTransInfo() {
        return this.transInfo;
    }

    public String getUin() {
        return this.uin;
    }

    public byte getUinType() {
        return this.uinType;
    }

    public byte[] getWupBuffer() {
        return this.wupBuffer;
    }

    public boolean isFastResendEnabled() {
        return ((Boolean) getAttribute("fastresend", Boolean.FALSE)).booleanValue();
    }

    public boolean isFirstPkgAfterConnOpen() {
        return ((Boolean) getAttribute(KEY_FIRST_PKG_AFTER_CONN_OPEN, Boolean.FALSE)).booleanValue();
    }

    public boolean isNeedCallback() {
        return this.needResp;
    }

    public boolean isNeedRemindSlowNetwork() {
        return false;
    }

    public boolean isQuickSendEnable() {
        return this.quickSendEnable;
    }

    public boolean isSupportRetry() {
        return this.mIsSupportRetry;
    }

    public void putWupBuffer(byte[] bArr) {
        this.wupBuffer = bArr;
    }

    public void readFromParcel(Parcel parcel) {
        try {
            this.appId = parcel.readInt();
            this.appSeq = parcel.readInt();
            this.serviceName = parcel.readString();
            this.uin = parcel.readString();
            this.uinType = parcel.readByte();
            this.serviceCmd = parcel.readString();
            this.timeout = parcel.readLong();
            this.extraData.clear();
            this.extraData.putAll(parcel.readBundle(Thread.currentThread().getContextClassLoader()));
            if (!this.mSkipBinderWhenMarshall) {
                //this.actionListener = IBaseActionListener.Stub.asInterface(parcel.readStrongBinder());
            }
            byte b2 = this.extraData.getByte("version");
            this.toVersion = b2;
            if (b2 > 0) {
                this.msfCommand = (MsfCommand) parcel.readSerializable();
                this.sendTimeout = parcel.readLong();
                this.needResp = parcel.readByte() != 0;
                this.mIsSupportRetry = parcel.readByte() != 0;
                byte[] bArr = new byte[parcel.readInt()];
                this.wupBuffer = bArr;
                parcel.readByteArray(bArr);
                this.ssoSeq = parcel.readInt();
                this.attributes.clear();
                parcel.readMap(this.attributes, ToServiceMsg.class.getClassLoader());
                this.transInfo.clear();
                parcel.readMap(this.transInfo, ToServiceMsg.class.getClassLoader());
            }
            this.quickSendEnable = parcel.readInt() == 1;
            this.quickSendStrategy = parcel.readInt();
        } catch (RuntimeException e2) {
            Log.d(tag, "readFromParcel RuntimeException", e2);
            throw e2;
        }
    }

    public void setAppId(int i2) {
        this.appId = i2;
    }

    public void setAppSeq(int i2) {
        this.appSeq = i2;
    }

    public void setAttributes(HashMap<String, Object> hashMap) {
        this.attributes = hashMap;
    }

    public void setEnableFastResend(boolean z) {
        addAttribute("fastresend", Boolean.valueOf(z));
    }

    public void setFirstPkgAfterConnOpen(boolean z) {
        addAttribute(KEY_FIRST_PKG_AFTER_CONN_OPEN, Boolean.valueOf(z));
    }

    public void setIsSupportRetry(boolean z) {
        this.mIsSupportRetry = z;
    }

    public void setMsfCommand(MsfCommand msfCommand) {
        this.msfCommand = msfCommand;
    }

    public void setNeedCallback(boolean z) {
        this.needResp = z;
    }

    public void setNeedRemindSlowNetwork(boolean z) {
        //addAttribute(BaseConstants.ATTRIBUTE_NEED_REMIND_SLOW_NETWORK, Boolean.valueOf(z));
    }

    public void setQuickSend(boolean z, int i2) {
        this.quickSendEnable = z;
        this.quickSendStrategy = i2;
    }

    public void setRequestSsoSeq(int i2) {
        this.ssoSeq = i2;
    }

    public void setSSOVersion(int i2) {
        this.mSsoVersion = i2;
    }

    public void setSendTimeout(long j2) {
        this.sendTimeout = j2;
    }

    public void setServiceCmd(String str) {
        this.serviceCmd = str;
    }

    public void setServiceName(String str) {
        this.serviceName = str;
    }

    public void setTimeout(long j2) {
        this.timeout = j2;
    }

    public void setTraceInfo(String str) {
        //this.attributes.put(BaseConstants.TPS_TELEMETRY_TRACING_INFO, str);
    }

    public void setUin(String str) {
        this.uin = str;
    }

    public void setUinType(byte b2) {
        this.uinType = b2;
    }

    public String toString() {
        return "TSM toString error";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {

    }

    public <T> T getAttribute(String str, T t) {
        return !this.attributes.containsKey(str) ? t : (T) this.attributes.get(str);
    }

    public ToServiceMsg(Parcel parcel) {
        this.mSsoVersion = 0;
        this.sendTimeout = -1L;
        this.timeout = -1L;
        this.appSeq = -1;
        this.wupBuffer = new byte[0];
        this.needResp = true;
        this.mIsSupportRetry = false;
        this.ssoSeq = -1;
        this.attributes = new HashMap<>(32);
        this.extraData = new Bundle();
        this.toVersion = (byte) 1;
        this.msfCommand = MsfCommand.unknown;
        this.uinType = (byte) 0;
        this.quickSendEnable = false;
        this.quickSendStrategy = -1;
        this.mSkipBinderWhenMarshall = false;
        this.transInfo = new HashMap<>();
        readFromParcel(parcel);
    }
}

