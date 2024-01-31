package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

public  final class GProApplicationChannelInfo implements Serializable {
    String appChannelIcon;
    String appChannelId;
    int appChannelJumpType;
    String appChannelJumpUrl;
    String appJumpSecret;
    int appQyyFlag;
    long applicationId;
    int externalUrlRequestStatus;
    long serialVersionUID;

    public GProApplicationChannelInfo() {
        this.serialVersionUID = 1L;
        this.appChannelId = "";
        this.appJumpSecret = "";
        this.appChannelIcon = "";
        this.appChannelJumpUrl = "";
    }

    public String getAppChannelIcon() {
        return this.appChannelIcon;
    }

    public String getAppChannelId() {
        return this.appChannelId;
    }

    public int getAppChannelJumpType() {
        return this.appChannelJumpType;
    }

    public String getAppChannelJumpUrl() {
        return this.appChannelJumpUrl;
    }

    public String getAppJumpSecret() {
        return this.appJumpSecret;
    }

    public int getAppQyyFlag() {
        return this.appQyyFlag;
    }

    public long getApplicationId() {
        return this.applicationId;
    }

    public int getExternalUrlRequestStatus() {
        return this.externalUrlRequestStatus;
    }

    public String toString() {
        return "GProApplicationChannelInfo{applicationId=" + this.applicationId + ",appChannelId=" + this.appChannelId + ",appJumpSecret=" + this.appJumpSecret + ",appQyyFlag=" + this.appQyyFlag + ",appChannelIcon=" + this.appChannelIcon + ",appChannelJumpType=" + this.appChannelJumpType + ",appChannelJumpUrl=" + this.appChannelJumpUrl + ",externalUrlRequestStatus=" + this.externalUrlRequestStatus + ",}";
    }

    public GProApplicationChannelInfo(long j2, String str, String str2, int i2, String str3, int i3, String str4, int i4) {
        this.serialVersionUID = 1L;
        this.appChannelId = "";
        this.appJumpSecret = "";
        this.appChannelIcon = "";
        this.appChannelJumpUrl = "";
        this.applicationId = j2;
        this.appChannelId = str;
        this.appJumpSecret = str2;
        this.appQyyFlag = i2;
        this.appChannelIcon = str3;
        this.appChannelJumpType = i3;
        this.appChannelJumpUrl = str4;
        this.externalUrlRequestStatus = i4;
    }
}
