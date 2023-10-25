package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class GProUserAVRspInfo {
    GProAVDevOptInfo devOpt;
    ArrayList<GProAVRoomCtrlOptInfo> roomDevOpts;
    GProSecurityResult secResult;
    String tipMsg;
    String trtcKey;
    int userState;

    public GProUserAVRspInfo() {
        this.tipMsg = "";
        this.secResult = new GProSecurityResult();
        this.trtcKey = "";
        this.devOpt = new GProAVDevOptInfo();
        this.roomDevOpts = new ArrayList<>();
    }

    public GProAVDevOptInfo getDevOpt() {
        return this.devOpt;
    }

    public ArrayList<GProAVRoomCtrlOptInfo> getRoomDevOpts() {
        return this.roomDevOpts;
    }

    public GProSecurityResult getSecResult() {
        return this.secResult;
    }

    public String getTipMsg() {
        return this.tipMsg;
    }

    public String getTrtcKey() {
        return this.trtcKey;
    }

    public int getUserState() {
        return this.userState;
    }

    public String toString() {
        return "GProUserAVRspInfo{tipMsg=" + this.tipMsg + ",secResult=" + this.secResult + ",trtcKey=" + this.trtcKey + ",userState=" + this.userState + ",devOpt=" + this.devOpt + ",roomDevOpts=" + this.roomDevOpts + ",}";
    }

    public GProUserAVRspInfo(String str, GProSecurityResult gProSecurityResult, String str2, int i2, GProAVDevOptInfo gProAVDevOptInfo, ArrayList<GProAVRoomCtrlOptInfo> arrayList) {
        this.tipMsg = "";
        this.secResult = new GProSecurityResult();
        this.trtcKey = "";
        this.devOpt = new GProAVDevOptInfo();
        this.roomDevOpts = new ArrayList<>();
        this.tipMsg = str;
        this.secResult = gProSecurityResult;
        this.trtcKey = str2;
        this.userState = i2;
        this.devOpt = gProAVDevOptInfo;
        this.roomDevOpts = arrayList;
    }
}
