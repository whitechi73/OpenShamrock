package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

public  final class GProEnterAudioLiveChannelRsp implements Serializable {
    String authMeta;
    GProAVChannelConfig avChannelConfig;
    boolean enableStream;
    int globalMutedFlag;
    GProEnterChannelPermission liveChannelPermission;
    long noStreamDisconnectTrtcSecond;
    GProEnterAVChannelPermissionInfo permissionInfo;
    String privateMapKey;
    String roomSessionId;
    int sdkAppId;
    long serialVersionUID;
    String showTips;
    long sigExpiresSecond;
    ArrayList<GProStreamInfo> streamInfoList;
    String trtcUserSign;
    ArrayList<GProUserBarNodePermission> userBarNodePermission;
    int userTRTC;
    long userTinyId;

    public GProEnterAudioLiveChannelRsp() {
        this.serialVersionUID = 1L;
        this.authMeta = "";
        this.trtcUserSign = "";
        this.privateMapKey = "";
        this.streamInfoList = new ArrayList<>();
        this.showTips = "";
        this.avChannelConfig = new GProAVChannelConfig();
        this.userBarNodePermission = new ArrayList<>();
        this.roomSessionId = "";
        this.permissionInfo = new GProEnterAVChannelPermissionInfo();
        this.liveChannelPermission = new GProEnterChannelPermission();
    }

    public String getAuthMeta() {
        return this.authMeta;
    }

    public GProAVChannelConfig getAvChannelConfig() {
        return this.avChannelConfig;
    }

    public boolean getEnableStream() {
        return this.enableStream;
    }

    public int getGlobalMutedFlag() {
        return this.globalMutedFlag;
    }

    public GProEnterChannelPermission getLiveChannelPermission() {
        return this.liveChannelPermission;
    }

    public long getNoStreamDisconnectTrtcSecond() {
        return this.noStreamDisconnectTrtcSecond;
    }

    public GProEnterAVChannelPermissionInfo getPermissionInfo() {
        return this.permissionInfo;
    }

    public String getPrivateMapKey() {
        return this.privateMapKey;
    }

    public String getRoomSessionId() {
        return this.roomSessionId;
    }

    public int getSdkAppId() {
        return this.sdkAppId;
    }

    public String getShowTips() {
        return this.showTips;
    }

    public long getSigExpiresSecond() {
        return this.sigExpiresSecond;
    }

    public ArrayList<GProStreamInfo> getStreamInfoList() {
        return this.streamInfoList;
    }

    public String getTrtcUserSign() {
        return this.trtcUserSign;
    }

    public ArrayList<GProUserBarNodePermission> getUserBarNodePermission() {
        return this.userBarNodePermission;
    }

    public int getUserTRTC() {
        return this.userTRTC;
    }

    public long getUserTinyId() {
        return this.userTinyId;
    }

    public String toString() {
        return "GProEnterAudioLiveChannelRsp{authMeta=" + this.authMeta + ",enableStream=" + this.enableStream + ",userTRTC=" + this.userTRTC + ",sdkAppId=" + this.sdkAppId + ",trtcUserSign=" + this.trtcUserSign + ",privateMapKey=" + this.privateMapKey + ",streamInfoList=" + this.streamInfoList + ",showTips=" + this.showTips + ",avChannelConfig=" + this.avChannelConfig + ",userBarNodePermission=" + this.userBarNodePermission + ",roomSessionId=" + this.roomSessionId + ",globalMutedFlag=" + this.globalMutedFlag + ",permissionInfo=" + this.permissionInfo + ",liveChannelPermission=" + this.liveChannelPermission + ",userTinyId=" + this.userTinyId + ",sigExpiresSecond=" + this.sigExpiresSecond + ",noStreamDisconnectTrtcSecond=" + this.noStreamDisconnectTrtcSecond + ",}";
    }

    public GProEnterAudioLiveChannelRsp(String str, boolean z, int i2, int i3, String str2, String str3, ArrayList<GProStreamInfo> arrayList, String str4, GProAVChannelConfig gProAVChannelConfig, ArrayList<GProUserBarNodePermission> arrayList2, String str5, int i4, GProEnterAVChannelPermissionInfo gProEnterAVChannelPermissionInfo, GProEnterChannelPermission gProEnterChannelPermission, long j2, long j3, long j4) {
        this.serialVersionUID = 1L;
        this.authMeta = "";
        this.trtcUserSign = "";
        this.privateMapKey = "";
        this.streamInfoList = new ArrayList<>();
        this.showTips = "";
        this.avChannelConfig = new GProAVChannelConfig();
        this.userBarNodePermission = new ArrayList<>();
        this.roomSessionId = "";
        this.permissionInfo = new GProEnterAVChannelPermissionInfo();
        this.liveChannelPermission = new GProEnterChannelPermission();
        this.authMeta = str;
        this.enableStream = z;
        this.userTRTC = i2;
        this.sdkAppId = i3;
        this.trtcUserSign = str2;
        this.privateMapKey = str3;
        this.streamInfoList = arrayList;
        this.showTips = str4;
        this.avChannelConfig = gProAVChannelConfig;
        this.userBarNodePermission = arrayList2;
        this.roomSessionId = str5;
        this.globalMutedFlag = i4;
        this.permissionInfo = gProEnterAVChannelPermissionInfo;
        this.liveChannelPermission = gProEnterChannelPermission;
        this.userTinyId = j2;
        this.sigExpiresSecond = j3;
        this.noStreamDisconnectTrtcSecond = j4;
    }
}
