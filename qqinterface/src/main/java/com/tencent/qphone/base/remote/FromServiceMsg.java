package com.tencent.qphone.base.remote;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import com.tencent.mobileqq.msf.sdk.MsfCommand;

import java.util.HashMap;

public class FromServiceMsg implements Parcelable, Cloneable {
    public static final Parcelable.Creator<FromServiceMsg> CREATOR = new Parcelable.Creator<FromServiceMsg>() { // from class: com.tencent.qphone.base.remote.FromServiceMsg.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FromServiceMsg createFromParcel(Parcel parcel) {
            return new FromServiceMsg(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FromServiceMsg[] newArray(int i2) {
            return new FromServiceMsg[i2];
        }
    };
    private static final String tag = "FromServiceMsg";
    private static final String version = "version";
    private int appId;
    private int appSeq;
    public HashMap<String, Object> attributes;
    private String errorMsg;
    @Deprecated
    public Bundle extraData;
    private int flag;
    private byte fromVersion;
    private boolean isColorLevel;
    private int mSsoEnc;
    private MsfCommand msfCommand;
    private byte[] msgCookie;
    private int resultCode;
    private String serviceCmd;
    private int ssoSeq;
    private final HashMap<String, byte[]> transInfo;
    private byte[] trpcRspErrorMsg;
    private int trpcRspFuncRetCode;
    private int trpcRspRetCode;
    private String uin;
    private byte[] wupBuffer;

    public FromServiceMsg() {
        this.errorMsg = "";
        this.mSsoEnc = 0;
        this.ssoSeq = -1;
        this.appSeq = -1;
        this.wupBuffer = new byte[0];
        this.attributes = new HashMap<>(32);
        this.fromVersion = (byte) 1;
        this.msfCommand = MsfCommand.unknown;
        this.msgCookie = new byte[0];
        this.trpcRspErrorMsg = new byte[0];
        this.transInfo = new HashMap<>();
        this.isColorLevel = false;
        Bundle bundle = new Bundle();
        this.extraData = bundle;
        try {
            bundle.putByte("version", this.fromVersion);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public synchronized Object addAttribute(String str, Object obj) {
        return this.attributes.put(str, obj);
    }

    public synchronized Object addTransInfo(String str, byte[] bArr) {
        return this.transInfo.put(str, bArr);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

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

    public int getBusinessFailCode(int i2) {
        int i3 = this.resultCode;
        return i3 == -1 ? i2 : i3;
    }

    public String getBusinessFailMsg() {
        return this.errorMsg;
    }

    public int getFlag() {
        return this.flag;
    }

    public byte getFromVersion() {
        return this.fromVersion;
    }

    public MsfCommand getMsfCommand() {
        return this.msfCommand;
    }

    public byte[] getMsgCookie() {
        return this.msgCookie;
    }

    public int getRequestSsoSeq() {
        return this.ssoSeq;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public String getServiceCmd() {
        return this.serviceCmd;
    }

    public String getShortStringForLog() {
        return "fsm getString error";
    }

    public int getSsoEnc() {
        return this.mSsoEnc;
    }

    public String getStringForLog() {
        return "fsm getString error";
    }

    public HashMap<String, byte[]> getTransInfo() {
        return this.transInfo;
    }

    public byte[] getTransInfoEntry(String str) {
        return this.transInfo.get(str);
    }

    public byte[] getTrpcRspErrorMsg() {
        return this.trpcRspErrorMsg;
    }

    public int getTrpcRspFuncRetCode() {
        return this.trpcRspFuncRetCode;
    }

    public int getTrpcRspRetCode() {
        return this.trpcRspRetCode;
    }

    public String getUin() {
        return this.uin;
    }

    public byte[] getWupBuffer() {
        return this.wupBuffer;
    }

    public boolean isColorLevel() {
        return this.isColorLevel;
    }

    public boolean isSuccess() {
        return this.resultCode == 1000;
    }

    public void putWupBuffer(byte[] bArr) {
        this.wupBuffer = bArr;
    }

    public void readFromParcel(Parcel parcel) {
        Log.d(tag, "readFromParcel RuntimeException");
    }

    public void setAppId(int i2) {
        this.appId = i2;
    }

    public void setAppSeq(int i2) {
        this.appSeq = i2;
    }

    public void setBusinessFail(int i2) {
        this.resultCode = i2;
    }

    public void setFlag(int i2) {
        this.flag = i2;
    }

    public void setFromVersion(byte b2) {
        this.fromVersion = b2;
    }

    public void setIsColorLevel(boolean z) {
        this.isColorLevel = z;
    }

    public void setMsfCommand(MsfCommand msfCommand) {
        this.msfCommand = msfCommand;
    }

    public void setMsgCookie(byte[] bArr) {
        this.msgCookie = bArr;
    }

    public void setMsgFail() {
        this.resultCode = 1001;
    }

    public void setMsgSuccess() {
        this.resultCode = 1000;
    }

    public void setRequestSsoSeq(int i2) {
        this.ssoSeq = i2;
    }

    public void setServiceCmd(String str) {
        this.serviceCmd = str;
    }

    public void setTrpcRspErrorMsg(byte[] bArr) {
        this.trpcRspErrorMsg = bArr;
    }

    public void setTrpcRspFuncRetCode(int i2) {
        this.trpcRspFuncRetCode = i2;
    }

    public void setTrpcRspRetCode(int i2) {
        this.trpcRspRetCode = i2;
    }

    public void setUin(String str) {
        this.uin = str;
    }

    public String toString() {
        return "fsm toString error";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Log.d(tag, "writeToParcel RuntimeException");
    }

    public <T> T getAttribute(String str, T t) {
        return !this.attributes.containsKey(str) ? t : (T) this.attributes.get(str);
    }

    public int getBusinessFailCode() {
        return this.resultCode;
    }

    public void setBusinessFail(int i2, String str) {
        this.resultCode = i2;
        this.errorMsg = str;
    }

    public void setBusinessFail(int i2, int i3, String str) {
        this.resultCode = i3;
        this.errorMsg = str;
    }

    public FromServiceMsg(String str, String str2) {
        this(-1, -1, str, str2);
        try {
            this.extraData.putByte("version", this.fromVersion);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public FromServiceMsg(int i2, int i3, String str, String str2) {
        this.errorMsg = "";
        this.mSsoEnc = 0;
        this.ssoSeq = -1;
        this.appSeq = -1;
        this.wupBuffer = new byte[0];
        this.attributes = new HashMap<>(32);
        this.fromVersion = (byte) 1;
        this.msfCommand = MsfCommand.unknown;
        this.msgCookie = new byte[0];
        this.trpcRspErrorMsg = new byte[0];
        this.transInfo = new HashMap<>();
        this.isColorLevel = false;
        Bundle bundle = new Bundle();
        this.extraData = bundle;
        this.resultCode = 1001;
        this.appId = i2;
        this.appSeq = i3;
        this.uin = str;
        this.serviceCmd = str2;
        try {
            bundle.putByte("version", this.fromVersion);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public FromServiceMsg(int i2, int i3, String str, String str2, byte[] bArr) {
        this.errorMsg = "";
        this.mSsoEnc = 0;
        this.ssoSeq = -1;
        this.appSeq = -1;
        this.wupBuffer = new byte[0];
        this.attributes = new HashMap<>(32);
        this.fromVersion = (byte) 1;
        this.msfCommand = MsfCommand.unknown;
        this.msgCookie = new byte[0];
        this.trpcRspErrorMsg = new byte[0];
        this.transInfo = new HashMap<>();
        this.isColorLevel = false;
        Bundle bundle = new Bundle();
        this.extraData = bundle;
        this.resultCode = 1001;
        this.appId = i2;
        this.appSeq = i3;
        this.uin = str;
        this.serviceCmd = str2;
        this.msgCookie = bArr;
        try {
            bundle.putByte("version", this.fromVersion);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public FromServiceMsg(Parcel parcel) {
        this.errorMsg = "";
        this.mSsoEnc = 0;
        this.ssoSeq = -1;
        this.appSeq = -1;
        this.wupBuffer = new byte[0];
        this.attributes = new HashMap<>(32);
        this.fromVersion = (byte) 1;
        this.msfCommand = MsfCommand.unknown;
        this.msgCookie = new byte[0];
        this.trpcRspErrorMsg = new byte[0];
        this.transInfo = new HashMap<>();
        this.isColorLevel = false;
        this.extraData = new Bundle();
        readFromParcel(parcel);
    }
}

