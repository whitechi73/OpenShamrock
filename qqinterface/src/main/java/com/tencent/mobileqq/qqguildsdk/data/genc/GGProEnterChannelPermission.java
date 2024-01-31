package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernel.nativeinterface.GProEnterChannelPermission;

import java.io.Serializable;

public  class GGProEnterChannelPermission implements Serializable {
    public final GProEnterChannelPermission mInfo;

    public GGProEnterChannelPermission(GProEnterChannelPermission gProEnterChannelPermission) {
        this.mInfo = gProEnterChannelPermission;
    }

    public boolean getAllowEnter() {
        return this.mInfo.getAllowEnter();
    }

    public boolean getAllowLive() {
        return this.mInfo.getAllowLive();
    }

    public String getDisallowLiveReason() {
        return this.mInfo.getDisallowLiveReason();
    }

    public String getDisallowReason() {
        return this.mInfo.getDisallowReason();
    }

    public int getLiveType() {
        return this.mInfo.getLiveType();
    }

    public String getLiveUrl() {
        return this.mInfo.getLiveUrl();
    }

    public long getMsgSeq() {
        return this.mInfo.getMsgSeq();
    }

    public String toString() {
        return this.mInfo.toString();
    }
}
